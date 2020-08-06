package org.tron.api;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.security.auth.login.AccountException;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;
import org.tron.common.ApiUtil;
import org.tron.common.utils.ByteArray;
import org.tron.common.utils.Commons;
import org.tron.config.Constant;
import org.tron.core.capsule.AccountCapsule;
import org.tron.core.capsule.BlockBalanceTraceCapsule;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.db.Manager;
import org.tron.core.db2.core.Chainbase;
import org.tron.core.exception.BadItemException;
import org.tron.core.services.interfaceOnSolidity.WalletOnSolidity;
import org.tron.core.store.AccountStore;
import org.tron.core.store.BalanceTraceStore;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.model.AccountBalanceRequest;
import org.tron.model.AccountBalanceResponse;
import org.tron.model.AccountIdentifier;
import org.tron.model.Amount;
import org.tron.model.BlockIdentifier;
import org.tron.model.Error;
import org.tron.common.Default;
import org.tron.model.PartialBlockIdentifier;

@Controller
@RequestMapping("${openapi.rosetta.base-path:}")
@Slf4j(topic = "db")
public class AccountApiController implements AccountApi {

    private final NativeWebRequest request;

    @Autowired
    private BalanceTraceStore balanceTraceStore;

    @org.springframework.beans.factory.annotation.Autowired
    public AccountApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    /**
     * POST /account/balance : Get an Account Balance
     * Get an array of all AccountBalances for an AccountIdentifier and the BlockIdentifier at which the balance lookup was performed. The BlockIdentifier must always be returned because some consumers of account balance data need to know specifically at which block the balance was calculated to compare balances they compute from operations with the balance returned by the node. It is important to note that making a balance request for an account without populating the SubAccountIdentifier should not result in the balance of all possible SubAccountIdentifiers being returned. Rather, it should result in the balance pertaining to no SubAccountIdentifiers being returned (sometimes called the liquid balance). To get all balances associated with an account, it may be necessary to perform multiple balance requests with unique AccountIdentifiers. It is also possible to perform a historical balance lookup (if the server supports it) by passing in an optional BlockIdentifier.
     *
     * @param accountBalanceRequest  (required)
     * @return Expected response to a valid request (status code 200)
     *         or unexpected error (status code 200)
     */
    @ApiOperation(value = "Get an Account Balance", nickname = "accountBalance", notes = "Get an array of all AccountBalances for an AccountIdentifier and the BlockIdentifier at which the balance lookup was performed. The BlockIdentifier must always be returned because some consumers of account balance data need to know specifically at which block the balance was calculated to compare balances they compute from operations with the balance returned by the node. It is important to note that making a balance request for an account without populating the SubAccountIdentifier should not result in the balance of all possible SubAccountIdentifiers being returned. Rather, it should result in the balance pertaining to no SubAccountIdentifiers being returned (sometimes called the liquid balance). To get all balances associated with an account, it may be necessary to perform multiple balance requests with unique AccountIdentifiers. It is also possible to perform a historical balance lookup (if the server supports it) by passing in an optional BlockIdentifier.", response = AccountBalanceResponse.class, tags={ "Account", })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Expected response to a valid request", response = AccountBalanceResponse.class),
        @ApiResponse(code = 200, message = "unexpected error", response = Error.class) })
    @RequestMapping(value = "/account/balance",
        produces = { "application/json" },
        consumes = { "application/json" },
        method = RequestMethod.POST)
    public ResponseEntity<AccountBalanceResponse> accountBalance(
        @ApiParam(value = "", required = true) @Valid @RequestBody
            AccountBalanceRequest accountBalanceRequest) {
        if (getRequest().isPresent()) {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    AccountBalanceResponse response = new AccountBalanceResponse();
                    PartialBlockIdentifier partialBlockIdentifier = null;
                    AccountIdentifier accountIdentifier = null;
                    try {
                        partialBlockIdentifier = accountBalanceRequest.getBlockIdentifier();
                        if (partialBlockIdentifier == null) {
                            throw new BadItemException();
                        }
                        BlockCapsule.BlockId blockId = new BlockCapsule.BlockId(
                            ByteArray.fromHexString(partialBlockIdentifier.getHash()), partialBlockIdentifier.getIndex());
                        BlockBalanceTraceCapsule blockBalanceTraceCapsule
                            = balanceTraceStore.getBlockBalanceTrace(blockId);
                        if (blockBalanceTraceCapsule == null) {
                            throw new BadItemException();
                        }

                        accountIdentifier = accountBalanceRequest.getAccountIdentifier();
                        if (accountIdentifier == null) {
                            throw new AccountException();
                        }
                        String address = accountIdentifier.getAddress();
                        Long balance = blockBalanceTraceCapsule.getBalance(address);
                        if (balance == null) {
                            balance = 0L;
                        }

                        response.blockIdentifier(new BlockIdentifier().index(partialBlockIdentifier.getIndex()).hash(partialBlockIdentifier.getHash()))
                            .addBalancesItem(new Amount().value(balance.toString()).currency(Default.CURRENCY));
                    } catch (BadItemException e) {
                        Error error = new Error()
                            .code(Constant.BLOCK_IS_NOT_EXISTS.getCode())
                            .message(Constant.BLOCK_IS_NOT_EXISTS.getMessage())
                            .details(partialBlockIdentifier);
                        return ApiUtil.sendError(request, JSON.toJSONString(error));
                    } catch (AccountException e) {
                        Error error = new Error()
                            .code(Constant.ACCOUNT_IS_NOT_EXISTS.getCode())
                            .message(Constant.ACCOUNT_IS_NOT_EXISTS.getMessage())
                            .details(partialBlockIdentifier);
                        return ApiUtil.sendError(request, JSON.toJSONString(error));
                    }
                    HttpHeaders headers = new HttpHeaders();
                    headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
                    return new ResponseEntity<>(response, headers, HttpStatus.OK);
                }
            }
        }

        return new ResponseEntity<>(HttpStatus.valueOf(200));
    }

}

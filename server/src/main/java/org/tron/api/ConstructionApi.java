/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.3.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.tron.api;

import org.tron.model.ConstructionCombineRequest;
import org.tron.model.ConstructionCombineResponse;
import org.tron.model.ConstructionDeriveRequest;
import org.tron.model.ConstructionDeriveResponse;
import org.tron.model.ConstructionHashRequest;
import org.tron.model.ConstructionHashResponse;
import org.tron.model.ConstructionMetadataRequest;
import org.tron.model.ConstructionMetadataResponse;
import org.tron.model.ConstructionParseRequest;
import org.tron.model.ConstructionParseResponse;
import org.tron.model.ConstructionPayloadsRequest;
import org.tron.model.ConstructionPayloadsResponse;
import org.tron.model.ConstructionPreprocessRequest;
import org.tron.model.ConstructionPreprocessResponse;
import org.tron.model.ConstructionSubmitRequest;
import org.tron.model.ConstructionSubmitResponse;
import org.tron.model.Error;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-07-17T15:25:41.238219+08:00[Asia/Shanghai]")

@Validated
@Api(value = "construction", description = "the construction API")
public interface ConstructionApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /construction/combine : Create Network Transaction from Signatures
     * Combine creates a network-specific transaction from an unsigned transaction and an array of provided signatures. The signed transaction returned from this method will be sent to the &#x60;/construction/submit&#x60; endpoint by the caller.
     *
     * @param constructionCombineRequest  (required)
     * @return Expected response to a valid request (status code 200)
     *         or unexpected error (status code 200)
     */
    @ApiOperation(value = "Create Network Transaction from Signatures", nickname = "constructionCombine", notes = "Combine creates a network-specific transaction from an unsigned transaction and an array of provided signatures. The signed transaction returned from this method will be sent to the `/construction/submit` endpoint by the caller.", response = ConstructionCombineResponse.class, tags={ "Construction", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Expected response to a valid request", response = ConstructionCombineResponse.class),
        @ApiResponse(code = 200, message = "unexpected error", response = Error.class) })
    @RequestMapping(value = "/construction/combine",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<ConstructionCombineResponse> constructionCombine(@ApiParam(value = "" ,required=true )  @Valid @RequestBody ConstructionCombineRequest constructionCombineRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"signed_transaction\" : \"signed_transaction\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /construction/derive : Derive an Address from a PublicKey
     * Derive returns the network-specific address associated with a public key. Blockchains that require an on-chain action to create an account should not implement this method.
     *
     * @param constructionDeriveRequest  (required)
     * @return Expected response to a valid request (status code 200)
     *         or unexpected error (status code 200)
     */
    @ApiOperation(value = "Derive an Address from a PublicKey", nickname = "constructionDerive", notes = "Derive returns the network-specific address associated with a public key. Blockchains that require an on-chain action to create an account should not implement this method.", response = ConstructionDeriveResponse.class, tags={ "Construction", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Expected response to a valid request", response = ConstructionDeriveResponse.class),
        @ApiResponse(code = 200, message = "unexpected error", response = Error.class) })
    @RequestMapping(value = "/construction/derive",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<ConstructionDeriveResponse> constructionDerive(@ApiParam(value = "" ,required=true )  @Valid @RequestBody ConstructionDeriveRequest constructionDeriveRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"metadata\" : \"{}\", \"address\" : \"address\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /construction/hash : Get the Hash of a Signed Transaction
     * TransactionHash returns the network-specific transaction hash for a signed transaction.
     *
     * @param constructionHashRequest  (required)
     * @return Expected response to a valid request (status code 200)
     *         or unexpected error (status code 200)
     */
    @ApiOperation(value = "Get the Hash of a Signed Transaction", nickname = "constructionHash", notes = "TransactionHash returns the network-specific transaction hash for a signed transaction.", response = ConstructionHashResponse.class, tags={ "Construction", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Expected response to a valid request", response = ConstructionHashResponse.class),
        @ApiResponse(code = 200, message = "unexpected error", response = Error.class) })
    @RequestMapping(value = "/construction/hash",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<ConstructionHashResponse> constructionHash(@ApiParam(value = "" ,required=true )  @Valid @RequestBody ConstructionHashRequest constructionHashRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"transaction_hash\" : \"transaction_hash\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /construction/metadata : Get Metadata for Transaction Construction
     * Get any information required to construct a transaction for a specific network. Metadata returned here could be a recent hash to use, an account sequence number, or even arbitrary chain state. The request used when calling this endpoint is often created by calling &#x60;/construction/preprocess&#x60; in an offline environment. It is important to clarify that this endpoint should not pre-construct any transactions for the client (this should happen in &#x60;/construction/payloads&#x60;). This endpoint is left purposely unstructured because of the wide scope of metadata that could be required.
     *
     * @param constructionMetadataRequest  (required)
     * @return Expected response to a valid request (status code 200)
     *         or unexpected error (status code 200)
     */
    @ApiOperation(value = "Get Metadata for Transaction Construction", nickname = "constructionMetadata", notes = "Get any information required to construct a transaction for a specific network. Metadata returned here could be a recent hash to use, an account sequence number, or even arbitrary chain state. The request used when calling this endpoint is often created by calling `/construction/preprocess` in an offline environment. It is important to clarify that this endpoint should not pre-construct any transactions for the client (this should happen in `/construction/payloads`). This endpoint is left purposely unstructured because of the wide scope of metadata that could be required.", response = ConstructionMetadataResponse.class, tags={ "Construction", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Expected response to a valid request", response = ConstructionMetadataResponse.class),
        @ApiResponse(code = 200, message = "unexpected error", response = Error.class) })
    @RequestMapping(value = "/construction/metadata",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<ConstructionMetadataResponse> constructionMetadata(@ApiParam(value = "" ,required=true )  @Valid @RequestBody ConstructionMetadataRequest constructionMetadataRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"metadata\" : { \"account_sequence\" : 23, \"recent_block_hash\" : \"0x52bc44d5378309ee2abf1539bf71de1b7d7be3b5\" } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /construction/parse : Parse a Transaction
     * Parse is called on both unsigned and signed transactions to understand the intent of the formulated transaction. This is run as a sanity check before signing (after &#x60;/construction/payloads&#x60;) and before broadcast (after &#x60;/construction/combine&#x60;). 
     *
     * @param constructionParseRequest  (required)
     * @return Expected response to a valid request (status code 200)
     *         or unexpected error (status code 200)
     */
    @ApiOperation(value = "Parse a Transaction", nickname = "constructionParse", notes = "Parse is called on both unsigned and signed transactions to understand the intent of the formulated transaction. This is run as a sanity check before signing (after `/construction/payloads`) and before broadcast (after `/construction/combine`). ", response = ConstructionParseResponse.class, tags={ "Construction", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Expected response to a valid request", response = ConstructionParseResponse.class),
        @ApiResponse(code = 200, message = "unexpected error", response = Error.class) })
    @RequestMapping(value = "/construction/parse",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<ConstructionParseResponse> constructionParse(@ApiParam(value = "" ,required=true )  @Valid @RequestBody ConstructionParseRequest constructionParseRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"signers\" : [ \"signers\", \"signers\" ], \"metadata\" : \"{}\", \"operations\" : [ { \"amount\" : { \"metadata\" : \"{}\", \"currency\" : { \"symbol\" : \"BTC\", \"metadata\" : { \"Issuer\" : \"Satoshi\" }, \"decimals\" : 8 }, \"value\" : \"1238089899992\" }, \"metadata\" : { \"asm\" : \"304502201fd8abb11443f8b1b9a04e0495e0543d05611473a790c8939f089d073f90509a022100f4677825136605d732e2126d09a2d38c20c75946cd9fc239c0497e84c634e3dd01 03301a8259a12e35694cc22ebc45fee635f4993064190f6ce96e7fb19a03bb6be2\", \"hex\" : \"48304502201fd8abb11443f8b1b9a04e0495e0543d05611473a790c8939f089d073f90509a022100f4677825136605d732e2126d09a2d38c20c75946cd9fc239c0497e84c634e3dd012103301a8259a12e35694cc22ebc45fee635f4993064190f6ce96e7fb19a03bb6be2\" }, \"related_operations\" : [ { \"index\" : 0, \"operation_identifier\" : { \"index\" : 0 } } ], \"type\" : \"Transfer\", \"account\" : { \"metadata\" : \"{}\", \"address\" : \"0x3a065000ab4183c6bf581dc1e55a605455fc6d61\", \"sub_account\" : { \"metadata\" : \"{}\", \"address\" : \"0x6b175474e89094c44da98b954eedeac495271d0f\" } }, \"operation_identifier\" : { \"index\" : 1, \"network_index\" : 0 }, \"status\" : \"Reverted\" }, { \"amount\" : { \"metadata\" : \"{}\", \"currency\" : { \"symbol\" : \"BTC\", \"metadata\" : { \"Issuer\" : \"Satoshi\" }, \"decimals\" : 8 }, \"value\" : \"1238089899992\" }, \"metadata\" : { \"asm\" : \"304502201fd8abb11443f8b1b9a04e0495e0543d05611473a790c8939f089d073f90509a022100f4677825136605d732e2126d09a2d38c20c75946cd9fc239c0497e84c634e3dd01 03301a8259a12e35694cc22ebc45fee635f4993064190f6ce96e7fb19a03bb6be2\", \"hex\" : \"48304502201fd8abb11443f8b1b9a04e0495e0543d05611473a790c8939f089d073f90509a022100f4677825136605d732e2126d09a2d38c20c75946cd9fc239c0497e84c634e3dd012103301a8259a12e35694cc22ebc45fee635f4993064190f6ce96e7fb19a03bb6be2\" }, \"related_operations\" : [ { \"index\" : 0, \"operation_identifier\" : { \"index\" : 0 } } ], \"type\" : \"Transfer\", \"account\" : { \"metadata\" : \"{}\", \"address\" : \"0x3a065000ab4183c6bf581dc1e55a605455fc6d61\", \"sub_account\" : { \"metadata\" : \"{}\", \"address\" : \"0x6b175474e89094c44da98b954eedeac495271d0f\" } }, \"operation_identifier\" : { \"index\" : 1, \"network_index\" : 0 }, \"status\" : \"Reverted\" } ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /construction/payloads : Generate an Unsigned Transaction and Signing Payloads
     * Payloads is called with an array of operations and the response from &#x60;/construction/metadata&#x60;. It returns an unsigned transaction blob and a collection of payloads that must be signed by particular addresses using a certain SignatureType. The array of operations provided in transaction construction often times can not specify all \&quot;effects\&quot; of a transaction (consider invoked transactions in Ethereum). However, they can deterministically specify the \&quot;intent\&quot; of the transaction, which is sufficient for construction. For this reason, parsing the corresponding transaction in the Data API (when it lands on chain) will contain a superset of whatever operations were provided during construction.
     *
     * @param constructionPayloadsRequest  (required)
     * @return Expected response to a valid request (status code 200)
     *         or unexpected error (status code 200)
     */
    @ApiOperation(value = "Generate an Unsigned Transaction and Signing Payloads", nickname = "constructionPayloads", notes = "Payloads is called with an array of operations and the response from `/construction/metadata`. It returns an unsigned transaction blob and a collection of payloads that must be signed by particular addresses using a certain SignatureType. The array of operations provided in transaction construction often times can not specify all \"effects\" of a transaction (consider invoked transactions in Ethereum). However, they can deterministically specify the \"intent\" of the transaction, which is sufficient for construction. For this reason, parsing the corresponding transaction in the Data API (when it lands on chain) will contain a superset of whatever operations were provided during construction.", response = ConstructionPayloadsResponse.class, tags={ "Construction", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Expected response to a valid request", response = ConstructionPayloadsResponse.class),
        @ApiResponse(code = 200, message = "unexpected error", response = Error.class) })
    @RequestMapping(value = "/construction/payloads",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<ConstructionPayloadsResponse> constructionPayloads(@ApiParam(value = "" ,required=true )  @Valid @RequestBody ConstructionPayloadsRequest constructionPayloadsRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"unsigned_transaction\" : \"unsigned_transaction\", \"payloads\" : [ { \"address\" : \"address\", \"hex_bytes\" : \"hex_bytes\" }, { \"address\" : \"address\", \"hex_bytes\" : \"hex_bytes\" } ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /construction/preprocess : Create a Request to Fetch Metadata
     * Preprocess is called prior to &#x60;/construction/payloads&#x60; to construct a request for any metadata that is needed for transaction construction given (i.e. account nonce). The request returned from this method will be used by the caller (in a different execution environment) to call the &#x60;/construction/metadata&#x60; endpoint.
     *
     * @param constructionPreprocessRequest  (required)
     * @return Expected response to a valid request (status code 200)
     *         or unexpected error (status code 200)
     */
    @ApiOperation(value = "Create a Request to Fetch Metadata", nickname = "constructionPreprocess", notes = "Preprocess is called prior to `/construction/payloads` to construct a request for any metadata that is needed for transaction construction given (i.e. account nonce). The request returned from this method will be used by the caller (in a different execution environment) to call the `/construction/metadata` endpoint.", response = ConstructionPreprocessResponse.class, tags={ "Construction", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Expected response to a valid request", response = ConstructionPreprocessResponse.class),
        @ApiResponse(code = 200, message = "unexpected error", response = Error.class) })
    @RequestMapping(value = "/construction/preprocess",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<ConstructionPreprocessResponse> constructionPreprocess(@ApiParam(value = "" ,required=true )  @Valid @RequestBody ConstructionPreprocessRequest constructionPreprocessRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"options\" : \"{}\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /construction/submit : Submit a Signed Transaction
     * Submit a pre-signed transaction to the node. This call should not block on the transaction being included in a block. Rather, it should return immediately with an indication of whether or not the transaction was included in the mempool. The transaction submission response should only return a 200 status if the submitted transaction could be included in the mempool. Otherwise, it should return an error.
     *
     * @param constructionSubmitRequest  (required)
     * @return Expected response to a valid request (status code 200)
     *         or unexpected error (status code 200)
     */
    @ApiOperation(value = "Submit a Signed Transaction", nickname = "constructionSubmit", notes = "Submit a pre-signed transaction to the node. This call should not block on the transaction being included in a block. Rather, it should return immediately with an indication of whether or not the transaction was included in the mempool. The transaction submission response should only return a 200 status if the submitted transaction could be included in the mempool. Otherwise, it should return an error.", response = ConstructionSubmitResponse.class, tags={ "Construction", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Expected response to a valid request", response = ConstructionSubmitResponse.class),
        @ApiResponse(code = 200, message = "unexpected error", response = Error.class) })
    @RequestMapping(value = "/construction/submit",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<ConstructionSubmitResponse> constructionSubmit(@ApiParam(value = "" ,required=true )  @Valid @RequestBody ConstructionSubmitRequest constructionSubmitRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"metadata\" : \"{}\", \"transaction_identifier\" : { \"hash\" : \"0x2f23fd8cca835af21f3ac375bac601f97ead75f2e79143bdf71fe2c4be043e8f\" } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
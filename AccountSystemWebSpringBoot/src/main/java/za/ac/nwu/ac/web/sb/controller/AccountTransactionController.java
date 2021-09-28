package za.ac.nwu.ac.web.sb.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountTransactionFlow;

import java.util.List;

@RestController
@RequestMapping("account-transaction")
public class AccountTransactionController {

    private final CreateAccountTransactionFlow createAccountTransactionFlow;
    private final FetchAccountTransactionFlow fetchAccountTransactionFlow;

    @Autowired
    public AccountTransactionController(CreateAccountTransactionFlow createAccountTransactionFlow,
                                        FetchAccountTransactionFlow fetchAccountTransactionFlow){
        this.createAccountTransactionFlow = createAccountTransactionFlow;
        this.fetchAccountTransactionFlow = fetchAccountTransactionFlow;
    }

    @PostMapping("")
    @ApiOperation(value = "Create a new AccountTransaction.", notes = "Creates a new AccountTransaction in the Database.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The AccountTransaction was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> create(
            @ApiParam(value = "Request body to create a new AccountTransaction.",
                    required = true)
            @RequestBody AccountTransactionDto AccountTransaction){
        AccountTransactionDto accountTransactionResponse = createAccountTransactionFlow.create(AccountTransaction);
        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, accountTransactionResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the configured Account types.", notes = "Returns a list of amount types")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account types returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<AccountTransactionDto>>> getAll() {
        List<AccountTransactionDto> AccountTransactions = fetchAccountTransactionFlow.getAllAccountTransactions();
        GeneralResponse<List<AccountTransactionDto>> response = new GeneralResponse<>(true, AccountTransactions);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("{transactionId}")
    @ApiOperation(value = "Fetches the specified AccountTransaction.", notes = "Fetches the accountTransaction corresponding to the given transactionId.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "AccountTransaction Found", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> getAllAccountTransactions(
            @ApiParam(value = "The transactionId that uniquely identifies the AccountTransaction.",
                    example = "50002",
                    name = "transactionId",
                    required = true)
            @PathVariable("transactionId") final Long transactionId){

        AccountTransactionDto AccountTransaction = fetchAccountTransactionFlow.getAccountTransactionById(transactionId);
        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, AccountTransaction);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}

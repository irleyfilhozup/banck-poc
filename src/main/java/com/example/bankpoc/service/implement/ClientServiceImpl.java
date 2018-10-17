package com.example.bankpoc.service.implement

import java.time.LocalDateTime
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import com.example.bankpoc.exception.BusinessException
import com.example.bankpoc.exception.NonExistentException
import com.example.bankpoc.models.entity.Account
import com.example.bankpoc.models.entity.Client
import com.example.bankpoc.models.request.ClientRequest
import com.example.bankpoc.models.response.ClientResponse
import com.example.bankpoc.repository.ClientRepository
import com.example.bankpoc.service.interfaceServ.AccountService
import com.example.bankpoc.service.interfaceServ.ClientService
import com.example.bankpoc.util.ValidCPF

@Component
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
class ClientServiceImpl : ClientService {

    @Autowired
    private val clientRepository: ClientRepository? = null

    @Autowired
    private val accountService: AccountService? = null

    @Transactional(propagation = Propagation.REQUIRED)
    override fun create(clientRequest: ClientRequest): ClientResponse {
        ValidCPF.check(clientRequest.cpf)
        this.checkIfCPFExists(clientRequest.cpf)
        val account = accountService!!.create(Account(LocalDateTime.now()))
        val client = Client()
        client.name = clientRequest.name
        client.cpf = clientRequest.cpf
        client.accountId = account.id
        client.createdAt = LocalDateTime.now()
        clientRepository!!.save(client)
        return ClientResponse(client.name, client.cpf, client.accountId)
    }

    override fun findByAccountIdResponse(accountId: Long?): ClientResponse {
        val client = clientRepository!!.findByAccountId(accountId)
        this.checkIfClientNotExists(client)
        return ClientResponse(client.name, client.cpf, client.accountId)
    }

    override fun findByAccountId(accountId: Long?): Client {
        val client = clientRepository!!.findByAccountId(accountId)
        this.checkIfClientNotExists(client)
        return client
    }

    override fun findByCpf(cpf: String): ClientResponse {
        val client = clientRepository!!.findByCpf(cpf)
        this.checkIfClientNotExists(client)
        return ClientResponse(client.name, client.cpf, client.accountId)
    }

    @Transactional(propagation = Propagation.REQUIRED)
    override fun update(clientRequest: ClientRequest, accountId: Long?): ClientResponse {
        val clientUpdated = this.findByAccountId(accountId)
        clientUpdated.name = clientRequest.name
        clientUpdated.cpf = clientRequest.cpf
        clientRepository!!.save(clientUpdated)
        return ClientResponse(clientUpdated.name, clientUpdated.cpf, clientUpdated.accountId)
    }

    override fun checkIfCPFExists(cpf: String) {
        val client = clientRepository!!.findByCpf(cpf)
        this.checkIfClientExists(client)
    }

    override fun checkIfClientExists(client: Client?) {
        if (client != null)
            throw BusinessException("Cliente já possui cadastro no banco de dados")
    }

    override fun checkIfClientNotExists(client: Client?) {
        if (client == null)
            throw NonExistentException("Conta Inexistente")
    }
}

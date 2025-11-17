package com.desafio.backend.service;

import com.desafio.backend.dto.ClienteRequestDTO;
import com.desafio.backend.dto.ClienteResponseDTO;
import com.desafio.backend.exception.ResourceNotFoundException;
import com.desafio.backend.model.Cliente;
import com.desafio.backend.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    private final ClienteRepository repo;

    public ClienteService(ClienteRepository repo) {
        this.repo = repo;
    }

    public List<ClienteResponseDTO> listar() {
        return repo.findAll().stream().map(this::toResponse).collect(Collectors.toList());
    }

    public ClienteResponseDTO salvar(ClienteRequestDTO dto) {
        Cliente c = new Cliente();
        c.setNome(dto.getNome());
        c.setCpf(dto.getCpf());
        Cliente saved = repo.save(c);
        return toResponse(saved);
    }

    public ClienteResponseDTO buscarPorId(Long id) {
        Cliente c = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com id: " + id));
        return toResponse(c);
    }

    public ClienteResponseDTO atualizar(Long id, ClienteRequestDTO dto) {
        Cliente c = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com id: " + id));
        c.setNome(dto.getNome());
        c.setCpf(dto.getCpf());
        Cliente updated = repo.save(c);
        return toResponse(updated);
    }

    public void deletar(Long id) {
        Cliente c = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com id: " + id));
        repo.delete(c);
    }

    private ClienteResponseDTO toResponse(Cliente c) {
        ClienteResponseDTO r = new ClienteResponseDTO();
        r.setId(c.getId());
        r.setNome(c.getNome());
        r.setCpf(c.getCpf());
        return r;
    }
}

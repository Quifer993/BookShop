package zolotorevskii.bookshop.services;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import zolotorevskii.bookshop.dto.BookDto;
import zolotorevskii.bookshop.dto.ClientDto;
import zolotorevskii.bookshop.models.Book;
import zolotorevskii.bookshop.models.Client;
import zolotorevskii.bookshop.repositories.BookRepository;
import zolotorevskii.bookshop.repositories.ClientRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class ClientService {
    ClientRepository clientRepository;
    private final ModelMapper modelMapper;

    public void put(ClientDto dto) {
        save(dto);
    }
    public void update(ClientDto dto) throws Exception {
        Long id = dto.getId();
        clientRepository.findById(id).orElseThrow(() -> new Exception("Client with id: (" + id + ")is missing."));
        save(dto);
    }

    private void save(ClientDto dto){
        Client client = new Client();
        BeanUtils.copyProperties(dto, client);
        clientRepository.save(client);
    }

    public List<ClientDto> getAll(){
        return clientRepository.findAll().stream().
                map((element) -> modelMapper.map(element, ClientDto.class))
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        clientRepository.findById(id).ifPresent(clientRepository::delete);
    }
}

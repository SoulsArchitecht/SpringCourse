package ru.sendel.pastebox.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import ru.sendel.pastebox.api.PublicStatus;
import ru.sendel.pastebox.api.request.PasteBoxRequest;
import ru.sendel.pastebox.repository.PasteBoxEntity;
import ru.sendel.pastebox.repository.PasteBoxRepository;
import ru.sendel.pastebox.api.response.PasteBoxResponse;
import ru.sendel.pastebox.api.response.PasteBoxUrlResponse;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "app")
public class PasteBoxServiceImpl implements PasteBoxService{

    private String host = "http://abc.ru";
    private int publicListSize = 10;


    private final PasteBoxRepository repository;
    private AtomicInteger idGenerator = new AtomicInteger(0);


    @Override
    public PasteBoxResponse getByHash(String hash) {
        PasteBoxEntity pasteBoxEntity = repository.getByHash(hash);

        return new PasteBoxResponse(pasteBoxEntity.getData(), pasteBoxEntity.isPublic());
    }

    @Override
    public List<PasteBoxResponse> getFirstPublicPasteBoxes()
    {
        List<PasteBoxEntity> list = repository.getListOfPublicAndAlive(publicListSize);
        return list.stream().map(pasteBoxEntity ->
                new PasteBoxResponse(pasteBoxEntity.getData(), pasteBoxEntity.isPublic()))
                .collect(Collectors.toList());
    }

    @Override
    public PasteBoxUrlResponse create(PasteBoxRequest request) {
        int hash = generateId();
        PasteBoxEntity pasteBoxEntity = new PasteBoxEntity();
        pasteBoxEntity.setData(request.getData());
        pasteBoxEntity.setId(hash);
        pasteBoxEntity.setHash(Integer.toHexString(hash));
        pasteBoxEntity.setPublic(request.getPublicStatus() == PublicStatus.PUBLIC);
        pasteBoxEntity.setLifetime(LocalDateTime.now().plusSeconds(request.getExpirationTimeSeconds()));
        repository.add(pasteBoxEntity);

        return new PasteBoxUrlResponse(host + "/" + pasteBoxEntity.getHash());
    }

    private int generateId() {
        return  idGenerator.getAndIncrement();
    }
}

package ru.sendel.pastebox.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sendel.pastebox.api.request.PasteBoxRequest;
import ru.sendel.pastebox.api.response.PasteBoxResponse;
import ru.sendel.pastebox.api.response.PasteBoxUrlResponse;
import ru.sendel.pastebox.service.PasteBoxService;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequiredArgsConstructor
public class PasteBoxController {
    private final PasteBoxService pasteBoxService;

    @GetMapping("/{hash}")
    public PasteBoxResponse getByHash(@PathVariable String hash)
    {
        return pasteBoxService.getByHash(hash);
    }

    @GetMapping("/")
    public Collection<PasteBoxResponse> getPublicPasteList()
    {
        return pasteBoxService.getFirstPublicPasteBoxes();
    }

    @PostMapping("/")
    public PasteBoxUrlResponse add(@RequestBody PasteBoxRequest request) {
        return pasteBoxService.create(request);
    }

}

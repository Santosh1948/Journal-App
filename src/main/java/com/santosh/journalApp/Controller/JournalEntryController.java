package com.santosh.journalApp.Controller;

import com.santosh.journalApp.Entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private final Map<Long, JournalEntry> journalEntries = new HashMap<>();
    private long idCounter = 1;

    @GetMapping
    public List<JournalEntry> getAll() {
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry) {
        myEntry.setId(idCounter++);
        journalEntries.put(myEntry.getId(), myEntry);
        return myEntry;
    }

    @GetMapping("/id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable long myId) {
        return journalEntries.get(myId);
    }

    @DeleteMapping("/id/{myId}")
    public JournalEntry deleteJournalEntryById(@PathVariable long myId) {
        return journalEntries.remove(myId);
    }

    @PutMapping("/id/{id}")
    public JournalEntry updateJournalById(
            @PathVariable long id,
            @RequestBody JournalEntry myEntry) {

        myEntry.setId(id); // ensure ID consistency
        return journalEntries.put(id, myEntry);
    }
}

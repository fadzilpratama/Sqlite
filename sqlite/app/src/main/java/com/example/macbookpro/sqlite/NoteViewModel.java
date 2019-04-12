package com.example.macbookpro.sqlite;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import java.util.List;
public class NoteViewModel extends AndroidViewModel {
    private NoteRepository repository;
    private LiveData<List<ContactsContract.CommonDataKinds.Note>> notes;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        this.repository = new NoteRepository(application);
        this.notes = repository.getNotes();
    }

    public LiveData<List<ContactsContract.CommonDataKinds.Note>> getNotes() {
        return notes;
    }

    public void insert(ContactsContract.CommonDataKinds.Note note) {
        repository.insert(note);
    }
    public void update(Note note) {
        repository.update(note);
    }
}
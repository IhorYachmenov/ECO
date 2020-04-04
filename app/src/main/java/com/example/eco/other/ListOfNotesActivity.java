package com.example.eco.other;

import android.app.AlertDialog;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.eco.R;

//Todo: delete all trash
public class ListOfNotesActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final int RC_EDITOR = 111;

    private CursorAdapter cursorAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        cursorAdapter = new NotesCursorAdapter(this, null, 0);  // used to add more customization the list items
        final ListView notesListView = findViewById(R.id.list_of_notes);
        notesListView.setAdapter(cursorAdapter);

        notesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListOfNotesActivity.this, NotesActivity.class);

                Uri noteUri = Uri.parse(NotesProvider.CONTENT_URI + "/" + id);
                intent.putExtra(NotesProvider.CONTENT_ITEM_TYPE, noteUri);
                startActivityForResult(intent, RC_EDITOR);
            }
        });

        getLoaderManager().initLoader(0, null,this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_create_notes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.create_notes:
                openEditorForNewNote();
                return true;
            case R.id.delete:
                if (cursorAdapter.isEmpty()) {
                    Toast.makeText(this, R.string.no_notes_to_delete_message, Toast.LENGTH_SHORT).show();
                } else {
                    deleteAllNotes();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void openEditorForNewNote() {
        startActivityForResult(new Intent(this, NotesActivity.class), RC_EDITOR);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RC_EDITOR) {
            if (resultCode == RESULT_OK) {
                restartLoader();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void deleteAllNotes() {
        DialogInterface.OnClickListener dialogClickListener =
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int button) {
                        if (button == DialogInterface.BUTTON_POSITIVE) {
                            // clear the database
                            getContentResolver().delete(NotesProvider.CONTENT_URI, null, null);
                            restartLoader();

                            Toast.makeText(ListOfNotesActivity.this,
                                    getString(R.string.all_notes_deleted_message),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.are_you_sure))
                .setPositiveButton(getString(android.R.string.yes), dialogClickListener)
                .setNegativeButton(getString(android.R.string.no), dialogClickListener)
                .show();
    }

    /**
     * Each time you change the data in the database you need to tell your Loader object that
     * it needs to restart, that it needs to reread the data from the backend database.
     */
    private void restartLoader() {
        getLoaderManager().restartLoader(0, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(this, NotesProvider.CONTENT_URI, null, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        cursorAdapter.swapCursor(data);

        // View or hide the no notes msg
        ViewGroup noNotesLinearLayout = findViewById(R.id.noNotesMsgLinearLayout);
        if (cursorAdapter.isEmpty()) {  // there's no notes in the database to view
            noNotesLinearLayout.setVisibility(View.VISIBLE);
        }
        else {   // there's indeed notes in the database to view
            noNotesLinearLayout.setVisibility(View.GONE);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        cursorAdapter.swapCursor(null);
    }
}

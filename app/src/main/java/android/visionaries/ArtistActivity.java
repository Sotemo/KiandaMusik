package android.visionaries;

import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.visionaries.adapters.TrackAdapter;
import android.visionaries.models.Album;
import android.visionaries.models.Artist;
import android.visionaries.models.ArtistTrackList;
import android.visionaries.models.Track;

import java.util.ArrayList;

public class ArtistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);


        BottomSheetDialog mBottomSheetDialog = new BottomSheetDialog(this);
        View sheetView = getLayoutInflater().inflate(R.layout.music_controls, null);
        mBottomSheetDialog.setContentView(sheetView);
        mBottomSheetDialog.show();

        setTitle("Força Suprema");
        Artist artist = new Artist(1, "Forca Suprema",
                "descricrption", R.drawable.header);
        Track track = new Track();
        track.setaName("Urna");
        track.setaArtist(artist);
        track.setaAlbum(new Album(1, "Forca", artist.getId()));
        track.setTrackCover(R.drawable.nga);
        Track a = new Track();
        a.setaName("Really");
        a.setaArtist(artist);
        a.setaAlbum(new Album(1, "Forca", artist.getId()));
        a.setTrackCover(R.drawable.fs);

        ArrayList<Track> tracks = new ArrayList<>();
        tracks.add(a);
        tracks.add(track);
        ArtistTrackList trackList = new ArtistTrackList(1, artist.getId(), tracks);

        RecyclerView recyclerView = findViewById(R.id.trackList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        TrackAdapter artistAdapter = new TrackAdapter(trackList);
        recyclerView.setAdapter(artistAdapter);


    }
}

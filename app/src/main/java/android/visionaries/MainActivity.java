package android.visionaries;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.visionaries.adapters.PopularTracksAdapter;
import android.visionaries.models.Album;
import android.visionaries.models.Artist;
import android.visionaries.models.PopularTrackList;
import android.visionaries.models.Track;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView destque = findViewById(R.id.destaque_cover);
        ConstraintLayout constraintLayout = findViewById(R.id.destaque_container);
        RecyclerView recyclerView = findViewById(R.id.artistList);
        Artist artist = new Artist();
        artist.setArtistCoverImage(R.drawable.big_shaq_track);
        artist.setId(0);
        artist.setDescription("");
        artist.setMusicStyle("RNB");
        artist.setName("Big Shaq");
        artist.setVerified(false);

        Album bigOne = new Album(0, "Big One", artist.getId());
        Track track = new Track();
        track.setaAlbum(bigOne);
        track.setaArtist(artist);
        track.setaName("Mans Bot Hot");
        track.setTrackCover(R.drawable.big_shaq_track);
        track.setTrackId(0);

        ArrayList<Track> tracks = new ArrayList<>();
        tracks.add(track);

        PopularTrackList popularTrackList = new PopularTrackList();
        popularTrackList.setPopularTracks(tracks);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PopularTracksAdapter tracksAdapter = new PopularTracksAdapter(this, popularTrackList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(tracksAdapter);
    }



}

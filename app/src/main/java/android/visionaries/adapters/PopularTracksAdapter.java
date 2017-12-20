package android.visionaries.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.visionaries.R;
import android.visionaries.models.PopularTrackList;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by AirtonLucas on 19/12/2017.
 */
public class PopularTracksAdapter extends RecyclerView.Adapter<PopularTracksAdapter.Viewholder> {

    private Context mContext;
    private PopularTrackList mPopularTrackList;
    public PopularTracksAdapter(Context context, PopularTrackList popularTrackList) {
        mContext = context;
        mPopularTrackList = popularTrackList;
    }

    public static class Viewholder extends RecyclerView.ViewHolder {
        ImageView trackCover;
        ImageView verifiedArtistBadge;
        TextView artistName;
        TextView trackTitle;
        public Viewholder(View itemView) {
            super(itemView);
            trackCover = itemView.findViewById(R.id.trackCover);
            verifiedArtistBadge = itemView.findViewById(R.id.verifiedBadge);
            artistName = itemView.findViewById(R.id.artistName);
            //trackTitle = itemView.findViewById(R.id.trackTitle);
        }
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.artist_card, parent, false);
        return new Viewholder(v);
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {
        holder.trackTitle.setText(mPopularTrackList.getPopularTracks().get(position).getaName());
        holder.artistName.setText(mPopularTrackList.getPopularTracks().get(position).getaArtist().getName());
        holder.trackCover.setImageResource(mPopularTrackList.getPopularTracks().get(position).getTrackCover());
    }

    @Override
    public int getItemCount() {
        return mPopularTrackList.getPopularTracks().size();
    }
}

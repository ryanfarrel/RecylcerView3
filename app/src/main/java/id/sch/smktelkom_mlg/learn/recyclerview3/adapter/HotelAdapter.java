package id.sch.smktelkom_mlg.learn.recyclerview3.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.learn.recyclerview3.R;
import id.sch.smktelkom_mlg.learn.recyclerview3.model.Hotel;

/**
 * Created by Ryan Farrel on 01/11/2016.
 */

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.ViewHolder> {
    ArrayList<Hotel> hotelList;
    IHotelAdapter mIHotelAdapter;


    public HotelAdapter(Context context, ArrayList<Hotel> hotelList) {
        this.hotelList = hotelList;
        mIHotelAdapter = (IHotelAdapter) context;
    }

    public HotelAdapter(ArrayList<Hotel> hotelList) {
        this.hotelList = hotelList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Hotel hotel = hotelList.get(position);
        holder.tvJudul.setText(hotel.judul);
        holder.tvDeskripsi.setText(hotel.deskripsi);
        holder.ivFoto.setImageURI(Uri.parse(hotel.foto));

    }


    @Override
    public int getItemCount() {
        if (hotelList != null)
            return hotelList.size();
        return 0;
    }

    public interface IHotelAdapter {
        void doClick(int pos);

        void doEdit(int pos);

        void doDelete(int pos);

        void doFav(int pos);

        void doShare(int pos);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivFoto;
        TextView tvJudul;
        TextView tvDeskripsi;
        Button bEdit, bDelete;
        ImageButton ibFav, ibShare;

        public ViewHolder(View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.imageView);
            tvJudul = (TextView) itemView.findViewById(R.id.textViewJudul);
            tvDeskripsi = (TextView) itemView.findViewById(R.id.textViewDeskripsi);
            bEdit = (Button) itemView.findViewById(R.id.buttonEdit);
            bDelete = (Button) itemView.findViewById(R.id.buttonDelete);
            ibFav = (ImageButton) itemView.findViewById(R.id.buttonFavorite);
            ibShare = (ImageButton) itemView.findViewById(R.id.buttonShare);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mIHotelAdapter.doClick(getAdapterPosition());
                }
            });

            bEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mIHotelAdapter.doEdit(getAdapterPosition());
                }
            });

            bDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mIHotelAdapter.doDelete(getAdapterPosition());
                }
            });

            ibFav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mIHotelAdapter.doFav(getAdapterPosition());
                }
            });

            ibShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mIHotelAdapter.doShare(getAdapterPosition());
                }
            });

        }
    }


}

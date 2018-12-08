package com.serkancay.multiplerecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.serkancay.multiplerecyclerview.Book.Type;
import java.util.List;

/**
 * Created by S.Serkan Cay on 5.12.2018
 */

public class BookListAdapter extends RecyclerView.Adapter<ViewHolder> {

    private final int RESOURCE_NORMAL_BOOK = R.layout.item_normal_book;

    private final int RESOURCE_DISCOUNTED_BOOK = R.layout.item_discounted_book;

    private List<Book> mBooks;

    private LayoutInflater mInflater;

    private LinearLayoutManager mLayoutManager;

    public BookListAdapter(Context context, List<Book> books) {
        mInflater = LayoutInflater.from(context);
        mLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        mBooks = books;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, final int viewType) {
        Type type = Type.values()[viewType];
        if (Type.NORMAL == type) {
            View row = mInflater.inflate(RESOURCE_NORMAL_BOOK, viewGroup, false);
            NormalBookHolder holder = new NormalBookHolder(row);
            return holder;
        } else if (Type.DISCOUNTED == type) {
            View row = mInflater.inflate(RESOURCE_DISCOUNTED_BOOK, viewGroup, false);
            DiscountedBookHolder holder = new DiscountedBookHolder(row);
            return holder;
        } else {
            return null;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Book book = mBooks.get(position);
        // ViewHolder.getItemViewType() bize Type enum'unun ordinal değerini vermektedir.
        Type type = Type.values()[holder.getItemViewType()];
        if (Type.NORMAL == type) {
            NormalBookHolder normalBookHolder = (NormalBookHolder) holder;
            normalBookHolder.ivBook.setImageResource(book.getImageResId());
            normalBookHolder.tvBookName.setText(book.getName());
            normalBookHolder.tvBookDescription.setText(book.getDescription());
            normalBookHolder.tvAuthor.setText(book.getAuthor());
            normalBookHolder.tvPublisher.setText(book.getPublisher());
            normalBookHolder.tvPrice.setText(String.format("%.2f", book.getPrice()) + " ₺");
        } else if (Type.DISCOUNTED == type) {
            DiscountedBookHolder discountedBookHolder = (DiscountedBookHolder) holder;
            discountedBookHolder.ivBook.setImageResource(book.getImageResId());
            discountedBookHolder.tvBookName.setText(book.getName());
            discountedBookHolder.tvBookDescription.setText(book.getDescription());
            discountedBookHolder.tvAuthor.setText(book.getAuthor());
            discountedBookHolder.tvPublisher.setText(book.getPublisher());
            String formattedPrice = String.format("%.2f", book.getPrice());
            SpannableString spannableString = new SpannableString(formattedPrice + " ₺");
            spannableString
                    .setSpan(new StrikethroughSpan(), 0, formattedPrice.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            discountedBookHolder.tvPrice.setText(spannableString);
            String formattedDiscountedPrice = String.format("%.2f", book.getDiscountedPrice());
            discountedBookHolder.tvDiscountedPrice.setText(formattedDiscountedPrice + " ₺");
        }
    }

    @Override
    public int getItemCount() {
        return mBooks.size();
    }

    @Override
    public int getItemViewType(final int position) {
        Book book = mBooks.get(position);
        return book.getType().ordinal();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull final RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        recyclerView.setLayoutManager(mLayoutManager);
    }

    public static class NormalBookHolder extends ViewHolder {

        public ImageView ivBook;

        public TextView tvBookName;

        public TextView tvBookDescription;

        public TextView tvAuthor;

        public TextView tvPublisher;

        public TextView tvPrice;

        public NormalBookHolder(View view) {
            super(view);
            ivBook = view.findViewById(R.id.ivBook);
            tvBookName = view.findViewById(R.id.tvBookName);
            tvBookDescription = view.findViewById(R.id.tvBookDescription);
            tvAuthor = view.findViewById(R.id.tvAuthor);
            tvPublisher = view.findViewById(R.id.tvPublisher);
            tvPrice = view.findViewById(R.id.tvPrice);
        }

    }

    public static class DiscountedBookHolder extends ViewHolder {

        public ImageView ivBook;

        public TextView tvBookName;

        public TextView tvBookDescription;

        public TextView tvAuthor;

        public TextView tvPublisher;

        public TextView tvPrice;

        public TextView tvDiscountedPrice;

        public DiscountedBookHolder(View view) {
            super(view);
            ivBook = view.findViewById(R.id.ivBook);
            tvBookName = view.findViewById(R.id.tvBookName);
            tvBookDescription = view.findViewById(R.id.tvBookDescription);
            tvAuthor = view.findViewById(R.id.tvAuthor);
            tvPublisher = view.findViewById(R.id.tvPublisher);
            tvPrice = view.findViewById(R.id.tvPrice);
            tvDiscountedPrice = view.findViewById(R.id.tvDiscountedPrice);
        }

    }

}

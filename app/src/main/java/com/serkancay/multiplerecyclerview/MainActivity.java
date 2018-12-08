package com.serkancay.multiplerecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import com.serkancay.multiplerecyclerview.Book.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvBooks;

    private BookListAdapter mBookListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvBooks = findViewById(R.id.rvBooks);
        List<Book> books = generateDummyList();
        mBookListAdapter = new BookListAdapter(this, books);
        rvBooks.setAdapter(mBookListAdapter);
    }

    private List<Book> generateDummyList() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(
                "Selahattin Eyyubi ve Aslan Yürekli Richard",
                "3. Haçlı Haçlı Seferinin Filistin Safhasının Romanı",
                "Yazar: Walter Scott",
                "Yayınevi : Ötüken Neşriyat",
                19.90,
                19.90,
                R.drawable.img_book_1,
                Type.NORMAL));
        books.add(
                new Book(
                        "Kader Anı",
                        "The Click Moment",
                        "Yazar: Frans Johansson",
                        "Yayınevi : Mediacat Yayıncılık",
                        35.00,
                        21.70,
                        R.drawable.img_book_2,
                        Type.DISCOUNTED));
        return books;
    }
}

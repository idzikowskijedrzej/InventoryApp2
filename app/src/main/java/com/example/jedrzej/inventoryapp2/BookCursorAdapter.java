package com.example.jedrzej.inventoryapp2;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.jedrzej.inventoryapp2.data.BookContract.BookEntry;

import org.w3c.dom.Text;

public class BookCursorAdapter extends CursorAdapter {

    public BookCursorAdapter(Context context, Cursor c){
        super(context, c,0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find individual views that we want to modify in the list item layout
        TextView nameTextView = view.findViewById(R.id.name);
        TextView authorTextView = view.findViewById(R.id.author);
        TextView priceTextView = view.findViewById(R.id.price_tv);
        TextView quantityTextView = view.findViewById(R.id.quantity_tv);

        // Find the columns of book attributes that we're interested in
        int nameColumnIndex = cursor.getColumnIndex(BookEntry.COLUMN_BOOK_NAME);
        int authorColumnIndex = cursor.getColumnIndex(BookEntry.COLUMN_BOOK_AUTHOR);
        int priceColumnIndex = cursor.getColumnIndex(BookEntry.COLUMN_BOOK_PRICE);
        int quantityColumnIndex = cursor.getColumnIndex(BookEntry.COLUMN_BOOK_QUANTITY);

        // Read the book attributes from the Cursor
        String bookName = cursor.getString(nameColumnIndex);
        String bookAuthor = cursor.getString(authorColumnIndex);
        String bookPrice = cursor.getDouble(priceColumnIndex) + " $";
        String bookQuantity = cursor.getInt(quantityColumnIndex) + " szt.";

        // If the book name or author is empty string or null
        // sue default text that says "Unknown breed", so the TextView isn't blank.
        if (TextUtils.isEmpty(bookAuthor)) {
            bookAuthor = context.getString(R.string.unknown_author);
        }

        // Update the TextViews with the attributes
        nameTextView.setText(bookName);
        authorTextView.setText(bookAuthor);
        priceTextView.setText(bookPrice);
        quantityTextView.setText(bookQuantity);
    }
}

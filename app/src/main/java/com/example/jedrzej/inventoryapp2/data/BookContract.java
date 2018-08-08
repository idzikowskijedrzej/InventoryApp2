package com.example.jedrzej.inventoryapp2.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public class BookContract {

    private BookContract(){}

    public static final String CONTENT_AUTHORITY = "com.example.jedrzej.inventoryapp2";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_BOOKS = "books";

    public static final class BookEntry implements BaseColumns {

        /** The content URI to access the book data in the provider */
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_BOOKS);

        /**
         * The MIME type of the {@link #CONTENT_URI} for a list of books.
         */
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_BOOKS;

        /**
         * The MIME type of the {@link #CONTENT_URI} for a single book.
         */
        public static final String CONTENT_ITEM_TYPE =

                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_BOOKS;

        /** Name of database table for book */
        public static final String TABLE_NAME = "books";

        public static final String _ID = BaseColumns._ID;

        public static final String COLUMN_BOOK_NAME ="name";

        public static final String COLUMN_BOOK_CATEGORY = "category";

        public static final String COLUMN_BOOK_PRICE = "price";

        public static final String COLUMN_BOOK_AUTHOR = "author";

        public static final String COLUMN_BOOK_QUANTITY = "quantity";

        /**
         * Possible values of book category.
         */
        public static final int CATEGORY_UNKNOWN = 0;
        public static final int CATEGORY_OPEN = 1;
        public static final int CATEGORY_MATURE = 2;


        /**
         * Returns whether or not the given category is {@link #CATEGORY_UNKNOWN}, {@link #CATEGORY_MATURE},
         * or {@link #CATEGORY_OPEN}.
         */
        public static boolean isValidCategory(int category) {
            if (category == CATEGORY_UNKNOWN || category == CATEGORY_OPEN || category == CATEGORY_MATURE  ) {
                return true;
            }
            return false;
        }
    }

}

package com.assignment.moviefinder.db.utils;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Model;
import com.activeandroid.query.Delete;
import com.activeandroid.query.From;
import com.activeandroid.query.Select;

import java.util.Arrays;
import java.util.List;

public class AADataManager {

    public AADataManager() {
        super();
    }

    public static <T extends Model> List<T> deleteAll(Class<? extends T> clazz) {
        return new Delete().from(clazz).execute();
    }

    public static List<Model> deleteAll(Class<? extends Model> clazz, String[] where, Object[] whereArgs) {

        if (whereArgs == null || where == null)
            return deleteAll(clazz);

        if (whereArgs.length != where.length)
            throw new IllegalArgumentException();

        From q = new Delete().from(clazz);

        for (int i = 0; i < where.length; i++) {
            q = q.where(where[i], whereArgs[i]);
        }

        return q.execute();
    }

    public static <T extends Model> void addAll(List<T> l) {
        ActiveAndroid.beginTransaction();
        try {
            for (T t : l) {
                if (t == null) {
                    throw new IllegalArgumentException("The object to save in database can't be null");
                }
                t.save();
            }
            ActiveAndroid.setTransactionSuccessful();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            ActiveAndroid.endTransaction();
        }
    }

    public static <T extends Model> void add(T... model) {
        List<T> l = Arrays.asList(model);
        addAll(l);
    }

    public static <T extends Model> List<T> getAll(Class<T> clazz) {
        return new Select().from(clazz).execute();
    }

    public static <T extends Model> List<T> getAll(Class<T> clazz, String[] where, Object[] whereArgs) {

        if (whereArgs == null || where == null)
            return getAll(clazz);

        if (whereArgs.length != where.length)
            throw new IllegalArgumentException();

        From q = new Select().from(clazz);

        for (int i = 0; i < where.length; i++) {
            q = q.where(where[i], whereArgs[i]);
        }

        return q.execute();
    }

    public static <T extends Model> List<T> getAll(Class<T> clazz, String[] where, Object[] whereArgs, String orderBy) {

        if (whereArgs == null || where == null)
            return getAll(clazz);

        if (whereArgs.length != where.length)
            throw new IllegalArgumentException();

        From q = new Select().from(clazz);

        for (int i = 0; i < where.length; i++) {
            q = q.where(where[i], whereArgs[i]);
        }

        q = q.orderBy(orderBy);

        return q.execute();
    }

    public static <T extends Model> T get(Class<T> clazz) {
        List<T> list = new Select().from(clazz).execute();
        if (list != null && list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    public static <T extends Model> T get(Class<T> clazz, String[] where, Object[] whereArgs) {

        if (whereArgs == null || where == null)
            return get(clazz);

        if (whereArgs.length != where.length)
            throw new IllegalArgumentException();

        From q = new Select().from(clazz);

        for (int i = 0; i < where.length; i++) {
            q = q.where(where[i], whereArgs[i]);
        }

        List<T> list = q.execute();
        if (list != null && list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }
}

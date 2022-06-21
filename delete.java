public boolean deleteUser(long id) {
  SQLiteDatabase database = this.getWritableDatabase();

  try {
      database.beginTransaction();
      String where = "id=" + id;
      database.delete(DB_TABLE, where, null);
      database.setTransactionSuccessful();
      Log.i("USER_DELETED", "ID: " + id);
  } catch (SQLException e) {
      Log.e("USER_DELETE_ERROR", "deleteUser: " + e.getMessage(), e);
  } finally {
      if (database.isOpen()) database.endTransaction();
  }
  return true;
}
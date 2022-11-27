DROP TABLE IF EXISTS plums_main_db;
DROP TABLE IF EXISTS libraries_books;
DROP TABLE IF EXISTS libraries;
DROP TABLE IF EXISTS readers;
DROP TABLE IF EXISTS books;

CREATE TABLE books (
  booknumber_pk int unsigned AUTO_INCREMENT,
  isbn varchar(30) NOT NULL,
  genre enum('ADVENTURE', 'COMPUTER_FORENSICS', 'CYBERSECURITY', 'EDUCATION', 'FICTION', 'JAVA', 'MANAGEMENT', 'RECIPES', 'SCIFI', 'SPIRITUAL', 'THRILLER') NOT NULL,
  title varchar(128) NOT NULL,
  book_authors varchar(128) NOT NULL,
  notes text(52),
  PRIMARY KEY (booknumber_pk)
);

CREATE TABLE readers (
  reader_pk int unsigned NOT NULL AUTO_INCREMENT,
  reader_id varchar(30) NOT NULL,
  booknumber_fk int unsigned DEFAULT NULL,
  first_name varchar(26) NOT NULL, 
  last_name varchar(42) NOT NULL,
  phone varchar(15),
  email varchar(32),
  PRIMARY KEY (reader_pk),
  FOREIGN KEY (booknumber_fk) REFERENCES books (booknumber_pk) ON DELETE CASCADE
);

CREATE TABLE libraries (
  libraryid_pk int unsigned NOT NULL AUTO_INCREMENT,
  booknumber_fk int unsigned NOT NULL,
  PRIMARY KEY (libraryid_pk),
  FOREIGN KEY (booknumber_fk) REFERENCES books (booknumber_pk) ON DELETE CASCADE
);

CREATE TABLE libraries_books (
  librarybookid_pk int unsigned NOT NULL AUTO_INCREMENT,
  libraryid_fk int unsigned NOT NULL,
  booknumber_fk int unsigned NOT NULL,
  PRIMARY KEY (librarybookid_pk),
  FOREIGN KEY (libraryid_fk) REFERENCES libraries (libraryid_pk) ON DELETE CASCADE,
  FOREIGN KEY (booknumber_fk) REFERENCES books (booknumber_pk) ON DELETE CASCADE
);

CREATE TABLE plums_main_db (
  plumsid_pk int unsigned NOT NULL AUTO_INCREMENT,
  reader_fk int unsigned NOT NULL,
  libraryid_fk int unsigned NOT NULL,
  booknumber_fk int unsigned NOT NULL,
  PRIMARY KEY (plumsid_pk),
  FOREIGN KEY (reader_fk) REFERENCES readers (reader_pk) ON DELETE CASCADE,
  FOREIGN KEY (libraryid_fk) REFERENCES libraries (libraryid_pk) ON DELETE CASCADE,
  FOREIGN KEY (booknumber_fk) REFERENCES books (booknumber_pk) ON DELETE CASCADE
);
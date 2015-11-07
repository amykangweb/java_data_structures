package com.teamtreehouse;

import java.io.Serializable;
import java.util.Date;

public class Treet implements Comparable, Serializable {
  static final long serialVersionUID = 7146681148113043748L;
  private boolean mBreakIt = true;
  private String mAuthor;
  private String mDescription;
  private Date mCreationDate;

  @Override
  public String toString() {
    return String.format("Treet: \"%s\" by %s on %s",
      mDescription, mAuthor, mCreationDate);
  }

  @Override
  public int compareTo(Object obj) {
    Treet other = (Treet) obj;
    if (equals(other)) {
      return 0;
    }
    int dateCmp = mCreationDate.compareTo(other.mCreationDate);
    if (dateCmp == 0) {
      return mDescription.compareTo(other.mDescription);
    }
    return dateCmp;
  }

  public Treet(String author, String description, Date creationDate) {
    mAuthor = author;
    mDescription = description;
    mCreationDate = creationDate;
  }

  public String getAuthor() {
    return mAuthor;
  }

  public String getDescription() {
    return mDescription;
  }

  public Date getCreationDate() {
    return mCreationDate;
  }

  public String[] getWords() {
    return mDescription.toLowerCase().split("[^\\w#@']+");
  }
}

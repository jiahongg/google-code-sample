package com.google;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/** A class used to represent a video. */
class Video implements Comparable<Video> {

  private final String title;
  private final String videoId;
  private final List<String> tags;
  private String flagReason;

  Video(String title, String videoId, List<String> tags) {
    this.title = title;
    this.videoId = videoId;
    this.tags = Collections.unmodifiableList(tags);
    this.flagReason = null;
  }

  /** Returns the title of the video. */
  String getTitle() {
    return title;
  }

  /** Returns the video id of the video. */
  String getVideoId() {
    return videoId;
  }

  /** Returns a readonly collection of the tags of the video. */
  List<String> getTags() {
    return tags;
  }

  public String getFlagReason() {
    return flagReason;
  }

  public void setFlagReason(String flagReason) {
    this.flagReason = flagReason;
  }

  @Override
  public int compareTo(Video other) {
    return this.title.compareTo(other.title);
  }

  @Override
  public String toString() {
    StringBuilder str = new StringBuilder();
    str.append(getTitle() + " (" + getVideoId() + ") [");
    for (int i = 0; i < getTags().size(); i++) {
      if (i != getTags().size() - 1) {
        str.append(getTags().get(i) + " ");
      } else {
        str.append(getTags().get(i));
      }
    }
    str.append("]");
    if(flagReason!=null){
      str.append(" - FLAGGED (reason: " + flagReason + ")");
    }
    return str.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Video video = (Video) o;
    return Objects.equals(title, video.title)
            && Objects.equals(videoId, video.videoId)
            && Objects.equals(tags, video.tags)
            && Objects.equals(flagReason, video.flagReason);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, videoId, tags, flagReason);
  }
}

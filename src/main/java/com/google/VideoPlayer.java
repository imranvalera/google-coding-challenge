package com.google;

import org.codehaus.plexus.logging.console.ConsoleLogger;

import javax.management.StringValueExp;
import java.io.Console;
import java.util.*;

public class VideoPlayer {
  ArrayList<String> arrList = new ArrayList<>();
  int count = 0;
  private Boolean pause = false;
  private Video currentVideo = null;
  public boolean isPlaying = false;
  private final VideoLibrary videoLibrary;

  public VideoPlayer() {
    this.videoLibrary = new VideoLibrary();
  }

  public void numberOfVideos() {
    System.out.printf("%s videos in the library%n", videoLibrary.getVideos().size());
  }

  public void showAllVideos() {
    var video = videoLibrary.getVideos();


    Collections.sort(video, new Comparator<Video>() {
      @Override
      public int compare(Video o1, Video o2) {
        return o1.getVideoId().compareTo(o2.getVideoId());
      }

    });


    System.out.println("Here's a list of all available videos:");
    for (Video vid : video) {

      System.out.printf(String.format("%s (%s) %s%n", vid.getTitle(), vid.getVideoId(), vid.getTags()).replaceAll(",", ""));
    }
  }

  public void playVideo(String videoId) {
    Video video = videoLibrary.getVideo(videoId);
    if (video == null) {
      System.out.println("Cannot play video: Video does not exist");
    }
    else {

      if (arrList.size() > 0) {
        System.out.println("Stopping video: " + arrList.get(0));
        arrList.remove(0);
        arrList.add(videoLibrary.getVideo(videoId).getTitle());
      } else{
        arrList.add(videoLibrary.getVideo(videoId).getTitle());
      }
      System.out.println("Playing video: " + videoLibrary.getVideo(videoId).getTitle());
    }
  }




  public void stopVideo() {
   // videoLibrary.getVideos().get(0).getVideoId();

    Video video = videoLibrary.getVideo(String.valueOf(currentVideo));
    if (video != null) {
      System.out.println("Cannot play video: Video does not exist");
    }
    else if (arrList.size() > 0){
      System.out.println("Stopping video: " + arrList.get(0));
      arrList.remove(0);
    }else {
      System.out.println("Cannot stop video: No video is currently playing");

    }
  }

  public void playRandomVideo() {
   // Video video = videoLibrary.getVideo(String.valueOf(currentVideo));
    Random rand = new Random();
    int range = videoLibrary.getVideos().size();
    if (arrList.size() > 0) {
      stopVideo();
    }
    playVideo(videoLibrary.getVideos().get(rand.nextInt(range)).getVideoId());
  }

  public void pauseVideo() {
    //Video video = videoLibrary.getVideo();
    if((arrList.size()>0)&&(count>0))
    {
      System.out.println("Video already paused: "+arrList.get(0));
      pause = false;
      return;
    }
    else if(arrList.size()>0)
    {
      System.out.println("Pausing video: "+arrList.get(0));
      pause = true;
      count++;
      return;
    }
    else{
      System.out.println("Cannot pause video: No video is currently playing");
  }
  }

  public void continueVideo() {
    if((count==0)&&(isPlaying))
    {
      System.out.println("Cannot continue video: Video is not paused");
    }
    else if((count>0)&&(!isPlaying))
    {
      System.out.println("Continuing video: "+arrList.get(0));
      isPlaying = true;
    }
    else if((count!=0)&& (isPlaying))
    {
      System.out.println("Cannot continue video: Video is not paused");

    }
    else
    {
      System.out.println("Cannot continue video: No video is currently playing");

    }
  }

  public void showPlaying() {
    String pauseStatus = "";
    if(pause){
      pauseStatus = " - PAUSED ";

    } else {
      pauseStatus = " ";
    }
    if(arrList.size()>0)
    {
      List<Video>  videos= videoLibrary.getVideos();
      for(Video video: videos)
      {
        if(video.getTitle()==arrList.get(0)) {

          System.out.print("Currently playing: "+getVideoString(video) + pauseStatus);
          System.out.println( getVideoString(video));
          pause = true;

        }
      }
    }
    else
    {
      System.out.println("No video is currently playing");
    }
  }
  public String getVideoString(Video video)
  {
    String tags=String.join(" ",video.getTags());
    return video.getTitle()+" ("+video.getVideoId()+") ["+tags+"]";
  }

  public void createPlaylist(String playlistName) {
  }

  public void addVideoToPlaylist(String playlistName, String videoId) {
    System.out.println("addVideoToPlaylist needs implementation");
  }

  public void showAllPlaylists() {
    System.out.println("showAllPlaylists needs implementation");
  }

  public void showPlaylist(String playlistName) {
    System.out.println("showPlaylist needs implementation");
  }

  public void removeFromPlaylist(String playlistName, String videoId) {
    System.out.println("removeFromPlaylist needs implementation");
  }

  public void clearPlaylist(String playlistName) {
    System.out.println("clearPlaylist needs implementation");
  }

  public void deletePlaylist(String playlistName) {
    System.out.println("deletePlaylist needs implementation");
  }

  public void searchVideos(String searchTerm) {
    System.out.println("searchVideos needs implementation");
  }

  public void searchVideosWithTag(String videoTag) {
    System.out.println("searchVideosWithTag needs implementation");
  }

  public void flagVideo(String videoId) {
    System.out.println("flagVideo needs implementation");
  }

  public void flagVideo(String videoId, String reason) {
    System.out.println("flagVideo needs implementation");
  }

  public void allowVideo(String videoId) {
    System.out.println("allowVideo needs implementation");
  }
}
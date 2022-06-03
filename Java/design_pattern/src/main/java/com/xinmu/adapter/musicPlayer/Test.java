package com.xinmu.adapter.musicPlayer;

/**
 * author: xinmu
 * date: 2022/6/1
 * time: 12:41
 */


public class Test {
    public static void main(String[] args) {
        MusicPlayer player = new PlayerAdapter();
        player.play("mp3", "xxx.mp3");
        player.play("wma", "xxx.wma");
    }
}

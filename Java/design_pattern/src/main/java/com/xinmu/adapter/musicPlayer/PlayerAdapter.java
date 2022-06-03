package com.xinmu.adapter.musicPlayer;

/**
 * author: xinmu
 * date: 2022/6/1
 * time: 12:39
 */


public class PlayerAdapter implements MusicPlayer{

    private MyPlayer player;

    public PlayerAdapter(MyPlayer player) {
        this.player = player;
    }

    public PlayerAdapter() {
        this.player = new MyPlayer();
    }

    @Override
    public void play(String type, String fileName) {
        if ("mp3".equals(type))
            this.player.playMp3(fileName);
        if ("wma".equals(type))
            this.player.playWma(fileName);
    }

}

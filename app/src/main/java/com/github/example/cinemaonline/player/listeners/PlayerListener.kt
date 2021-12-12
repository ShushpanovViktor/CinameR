package com.github.example.cinemaonline.player.listeners

import com.github.example.cinemaonline.player.PlayerVideoService
import com.google.android.exoplayer2.Player

class PlayerListener(
    private val playerVideoService: PlayerVideoService
) : Player.Listener {
    override fun onPlaybackStateChanged(playbackState: Int) {
        super.onPlaybackStateChanged(playbackState)
        if (playbackState == Player.STATE_READY)
            playerVideoService.stopForeground(false)
    }

    override fun onPlayWhenReadyChanged(playWhenReady: Boolean, reason: Int) {
        super.onPlayWhenReadyChanged(playWhenReady, reason)
        if (!playWhenReady)
            playerVideoService.stopForeground(false)
    }
}
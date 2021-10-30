package com.github.kadehar.cion.feature.movie_player_screen.ui

import android.annotation.SuppressLint
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.kadehar.cion.R
import com.github.kadehar.cion.databinding.FragmentMoviePlayerBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.util.Util
import org.koin.android.ext.android.inject

class MoviePlayerFragment : Fragment(R.layout.fragment_movie_player) {
    companion object {
        private const val URL_KEY = "url"
        fun newInstance(url: String) = MoviePlayerFragment().apply {
            arguments = bundleOf(Pair(URL_KEY, url))
        }
    }

    private val binding: FragmentMoviePlayerBinding
            by viewBinding(FragmentMoviePlayerBinding::bind)

    private val url: String by lazy {
        requireArguments().getString(URL_KEY)!!
    }

    private var player: SimpleExoPlayer? = null
    private var playWhenReady = true
    private var currentWindow = 0
    private var playbackPosition = 0L

    override fun onStart() {
        super.onStart()
        hideSystemUi()
        if (Util.SDK_INT >= 24) {
            initializePlayer()
        }
    }

    override fun onResume() {
        super.onResume()
        hideSystemUi()
        if ((Util.SDK_INT < 24)) {
            initializePlayer()
        }
    }

    override fun onPause() {
        super.onPause()
        if (Util.SDK_INT < 24) {
            releasePlayer()
        }
    }

    override fun onStop() {
        super.onStop()
        if (Util.SDK_INT >= 24) {
            releasePlayer()
        }
    }

    private fun initializePlayer() {
        player = SimpleExoPlayer.Builder(requireContext())
            .build().also { videoPlayer ->
            binding.videoPlayerView.player = videoPlayer
            videoPlayer.setMediaItem(MediaItem.fromUri(url))
            videoPlayer.playWhenReady = playWhenReady
            videoPlayer.seekTo(currentWindow, playbackPosition)
            videoPlayer.prepare()
        }
    }

    @SuppressLint("InlinedApi")
    private fun hideSystemUi() {
        binding.videoPlayerView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LOW_PROFILE
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                )
    }

    private fun releasePlayer() {
        player?.run {
            playbackPosition = this.currentPosition
            currentWindow = this.currentWindowIndex
            playWhenReady = this.playWhenReady
            release()
        }
        player = null
    }
}
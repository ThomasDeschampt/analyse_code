package com.simplecity.amp_library.ui.views

import com.simplecity.amp_library.model.Playlist
import com.simplecity.amp_library.model.Song
import com.simplecity.amp_library.ui.screens.nowplaying.PlayerView

abstract class PlayerViewAdapter : PlayerView {

    override fun setSeekProgress(progress: Int) {
        // a mediter
    }

    override fun currentTimeVisibilityChanged(visible: Boolean) {
        // a mediter
    }

    override fun currentTimeChanged(seconds: Long) {
        // a mediter
    }

    override fun totalTimeChanged(seconds: Long) {
        // a mediter
    }

    override fun queueChanged(queuePosition: Int, queueLength: Int) {
        // a mediter
    }

    override fun playbackChanged(isPlaying: Boolean) {
        // a mediter
    }   

    override fun shuffleChanged(shuffleMode: Int) {
        // a mediter
    }

    override fun repeatChanged(repeatMode: Int) {
        // a mediter
    }

    override fun favoriteChanged(isFavorite: Boolean) {
        // a mediter
    }

    override fun trackInfoChanged(song: Song?) {
        // a mediter
    }

    override fun showLyricsDialog() {
        // a mediter
    }

    override fun showUpgradeDialog() {
        // a mediter
    }

    override fun presentCreatePlaylistDialog(songs: List<Song>) {
        // a mediter
    }

    override fun presentSongInfoDialog(song: Song) {
        // a mediter
    }

    override fun onSongsAddedToPlaylist(playlist: Playlist, numSongs: Int) {
        // a mediter
    }

    override fun onSongsAddedToQueue(numSongs: Int) {
        // a mediter
    }

    override fun presentTagEditorDialog(song: Song) {
        // a mediter
    }

    override fun presentDeleteDialog(songs: List<Song>) {
        // a mediter
    }

    override fun shareSong(song: Song) {
        // a mediter
    }

    override fun presentRingtonePermissionDialog() {
        // a mediter
    }

    override fun showRingtoneSetMessage() {
        // a mediter
    }
}
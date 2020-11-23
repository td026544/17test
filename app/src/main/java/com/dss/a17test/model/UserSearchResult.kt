package com.dss.a17test.model

data class UserSearchResult(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val total_count: Int
){
    data class Item(
        val avatar_url: String,
        val followers_url: String,
        val gravatar_id: String,
        val html_url: String,
        val id: Int,
        val login: String,
        val node_id: String,
        val organizations_url: String,
        val received_events_url: String,
        val repos_url: String,
        val score: Double,
        val subscriptions_url: String,
        val type: String,
        val url: String
    )
}
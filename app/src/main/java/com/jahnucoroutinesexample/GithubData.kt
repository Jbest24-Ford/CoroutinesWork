package com.jahnucoroutinesexample

import com.google.gson.annotations.SerializedName

class GithubData {
    @SerializedName("commit")
    private lateinit var commit : Commit

    fun ParseGithubData(commit: Commit) {
        this.commit = commit
    }

    fun getCommit(): Commit {
        return commit
    }

    fun getCommitName(): String {
        return commit.getAuthor().getName()
    }

    fun getCommitDate(): String {
        return commit.getAuthor().getDate()
    }

    fun getCommitEmail(): String {
        return commit.getAuthor().getEmail()
    }

    fun getCommitMessage(): String {
        return commit.getMessage()
    }

    class Commit {
        @SerializedName("author")
        private lateinit var author: Author

        @SerializedName("message")
        private lateinit var message: String

        fun Commit(author: Author, message: String) {
            this.author = author
            this.message = message
        }

        fun getAuthor(): Author {
            return author
        }

        fun getMessage(): String {
            return message
        }
    }

    class Author {

        @SerializedName("name")
        private lateinit var name: String

        @SerializedName("email")
        private lateinit var email: String

        @SerializedName("date")
        private lateinit var date: String

        fun Author(name: String, email: String, date: String) {
            this.name = name
            this.email = email
            this.date = date
        }

        fun getName(): String {
            return name
        }

        fun getEmail(): String {
            return email
        }

        fun getDate(): String {
            return date
        }
    }

}
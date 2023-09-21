package com.example.androidbase.presentation.ui.example

class Util {
    companion object {
        var isProduction = true
        var BEAR = if (isProduction) {
            "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJodHRwczovL2l0c3RoZXpvbmUudXMuYXV0aDAuY29tLyIsInN1YiI6ImVtYWlsfDY0NjdiZDllZjBkN2M5YzU2ZDc5YjAzNyIsImF1ZCI6Imh0dHBzOi8vYXBpLml0c3RoZXpvbmUuY29tL2FwaS92MS8iLCJpYXQiOjE2OTUyNTk3MDYsImV4cCI6MTY5NTM0NjEwNiwiYXpwIjoiRUJRSzI3aFI0d0hsUFV5YnVVaFJ6WTAyQlVmMjFLTTIiLCJzY29wZSI6InJlYWQ6Y3VycmVudF91c2VyIG9mZmxpbmVfYWNjZXNzIiwiZ3R5IjpbInJlZnJlc2hfdG9rZW4iLCJwYXNzd29yZCJdfQ.hbNAw0B3JaOdnMk3nQzdRzxS-vX7vcpi_c2KXDE4ThQ"
        } else {
            "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJodHRwczovL2l0c3RoZXpvbmUudXMuYXV0aDAuY29tLyIsInN1YiI6ImVtYWlsfDY0NjdiZDllZjBkN2M5YzU2ZDc5YjAzNyIsImF1ZCI6Imh0dHBzOi8vYXBpLml0c3RoZXpvbmUuY29tL2FwaS92MS8iLCJpYXQiOjE2OTUyNTk3MDYsImV4cCI6MTY5NTM0NjEwNiwiYXpwIjoiRUJRSzI3aFI0d0hsUFV5YnVVaFJ6WTAyQlVmMjFLTTIiLCJzY29wZSI6InJlYWQ6Y3VycmVudF91c2VyIG9mZmxpbmVfYWNjZXNzIiwiZ3R5IjpbInJlZnJlc2hfdG9rZW4iLCJwYXNzd29yZCJdfQ.hbNAw0B3JaOdnMk3nQzdRzxS-vX7vcpi_c2KXDE4ThQ"
        }
    }
}
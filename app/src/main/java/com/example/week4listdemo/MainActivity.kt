package com.example.week4listdemo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        renderList()

    }

    private fun getMovieData():List<Movie>{
        return listOf(
            Movie("Lorem Ipsum", "This is a long description of a movie called lorem ipsum and this is awesome."),
            Movie("Movie Two", "This is a long description of a movie called Movie Two and this is awesome."),
            Movie("Fast and Furious", "This is a long description of a movie called Fast and Furious and this is awesome."),
            Movie("Android reigns Supreme", "No description needed. Android is just better"),
            Movie("iPhone", "It took me so many years to be able to pause video while recording. Call me the internet explorer of the mobile world"),
            Movie("Water Bottle", "Thirsty people drink water. Stay hydrated."),
            Movie("The struggle", "When is A1 going to drop? Stay tuned for the next episode"),
            Movie("The week 7", "It's the unspoken rule that the 7th week is just... Tears."),
            Movie("The week 8", "I survived week 7. I think. Coursework marks may say otherwise"),
            Movie("The week 11", "Coursework really did say otherwise. Watch the grind of the students going full tryhard for finals"),
            Movie("Week 12", "It continues..."),
            Movie("Week 13", "Teaching is done, will any students fall into the trap of getting relaxed before exams?"),
            Movie("Christmas", "What does Christmas have in store? Would I get my marks? Did I pass? Stay tuned"),
        )
    }

    private fun renderList(){
        val mainLayout: RecyclerView = findViewById(R.id.rvMovies)
        val movies:List<Movie> = getMovieData()
        val movieAdapterInst = MovieAdapter(movies)
        mainLayout.adapter = movieAdapterInst
        mainLayout.layoutManager = LinearLayoutManager(this)
    }
}
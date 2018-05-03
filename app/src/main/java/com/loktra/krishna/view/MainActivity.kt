package com.loktra.krishna.view

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.TextView
import com.loktra.krishna.ArchiApplication

import com.loktra.krishna.R
import com.loktra.krishna.RepositoryAdapter
import com.loktra.krishna.model.Commit
import com.loktra.krishna.model.Repository
import com.loktra.krishna.presenter.MainPresenter
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainMvpView {

    @Inject lateinit var presenter: MainPresenter

    private var reposRecycleView: RecyclerView? = null
    private var toolbar: Toolbar? = null
    private var progressBar: ProgressBar? = null
    private var infoTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as ArchiApplication).archiComponent.inject(this)
        //Set up presenter
        presenter = MainPresenter()
        presenter.attachView(this)

        progressBar = findViewById<View>(R.id.progress) as ProgressBar
        infoTextView = findViewById<View>(R.id.text_info) as TextView
        //Set up ToolBar
        toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        //Set up RecyclerView
        reposRecycleView = findViewById<View>(R.id.repos_recycler_view) as RecyclerView
        setupRecyclerView(reposRecycleView!!)

        presenter.loadRepositories("rails", "rails")

        // Set up search button
        /*
        searchButton = (ImageButton) findViewById(R.id.button_search);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.loadRepositories(editTextUsername.getText().toString());
            }
        });
        //Set up username EditText
        editTextUsername = (EditText) findViewById(R.id.edit_text_username);
        editTextUsername.addTextChangedListener(mHideShowButtonTextWatcher);
        editTextUsername.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    presenter.loadRepositories(editTextUsername.getText().toString());
                    return true;
                }
                return false;
            }
        });
*/
    }

    // MainMvpView interface methods implementation

    override fun onDestroy() {
        presenter!!.detachView()
        super.onDestroy()
    }

    override fun getContext(): Context {
        return this
    }

    override fun showRepositories(repositories: List<Commit>) {
        val adapter = reposRecycleView!!.adapter as RepositoryAdapter
        adapter.setRepositories(repositories, this@MainActivity)
        adapter.notifyDataSetChanged()
        reposRecycleView!!.requestFocus()
        //        hideSoftKeyboard();
        progressBar!!.visibility = View.INVISIBLE
        infoTextView!!.visibility = View.INVISIBLE
        reposRecycleView!!.visibility = View.VISIBLE
    }

    override fun showMessage(stringId: Int) {
        progressBar!!.visibility = View.INVISIBLE
        infoTextView!!.visibility = View.VISIBLE
        reposRecycleView!!.visibility = View.INVISIBLE
        infoTextView!!.text = getString(stringId)
    }

    override fun showProgressIndicator() {
        progressBar!!.visibility = View.VISIBLE
        infoTextView!!.visibility = View.INVISIBLE
        reposRecycleView!!.visibility = View.INVISIBLE
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        val adapter = RepositoryAdapter()
        /*
        adapter.setCallback(new RepositoryAdapter.Callback() {
            @Override
            public void onItemClick(Repository repository) {
                startActivity(RepositoryActivity.newIntent(MainActivity.this, repository));
            }
        });
*/
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    /*
    private void hideSoftKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editTextUsername.getWindowToken(), 0);
    }

    private TextWatcher mHideShowButtonTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
            searchButton.setVisibility(charSequence.length() > 0 ? View.VISIBLE : View.GONE);
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
*/

}

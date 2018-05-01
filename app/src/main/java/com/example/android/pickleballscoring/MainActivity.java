package com.example.android.pickleballscoring;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public static final int POINT_VALUE = 1;
    public static final int FAULT_VALUE = 1;

    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int faultsTeamA = 0;
    int faultsTeamB = 0;
    String servingTeam = "A";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Add a point for team A
    public void addPointTeamA(View view) {

        //Only add points for team A if they are the serving team
        if (servingTeam.equals("A")) {
            scoreTeamA += POINT_VALUE;
        }

        //Update the score displayed
        displayForTeamA(scoreTeamA);
    }

    //Add a point for team B
    public void addPointTeamB(View view) {

        //Only add points for team B if they are the serving team
        if (servingTeam.equals("B")) {
            scoreTeamB += POINT_VALUE;
        }

        //Update the score displayed
        displayForTeamB(scoreTeamB);
    }

    //Add a fault for team A
    public void addFaultTeamA(View view) {

        //Only add faults for team A if they are the serving team
        if (servingTeam.equals("A")) {
            faultsTeamA += FAULT_VALUE;

            //If team A reaches 2 faults, then the serve switches to team B
            if (faultsTeamA > 1) {
                servingTeam = "B";
                faultsTeamA = 0;
                displayServeTeam(servingTeam);
            }

            displayFaultsTeamA(faultsTeamA);
        }
    }

    //Add a fault for team B
    public void addFaultTeamB(View view) {

        //Only add faults for team B if they are the serving team
        if (servingTeam.equals("B")) {
            faultsTeamB += FAULT_VALUE;

            //If team B reaches 2 faults, then the serve switches to team A
            if (faultsTeamB > 1) {
                servingTeam = "A";
                faultsTeamB = 0;
                displayServeTeam(servingTeam);
            }

            displayFaultsTeamB(faultsTeamB);
        }
    }

    //Displays the given score for Team A
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    //Displays the given score for Team B
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    //Displays the faults for team A
    public void displayFaultsTeamA(int faultsTeamA) {
        TextView faultsView = (TextView) findViewById(R.id.faultsTeamA);
        String faultsMessage = getString(R.string.faults_text) + String.valueOf(faultsTeamA);
        faultsView.setText(faultsMessage);
    }

    //Displays the faults for team B
    public void displayFaultsTeamB(int faultsTeamB) {
        TextView faultsView = (TextView) findViewById(R.id.faultsTeamB);
        String faultsMessage = getString(R.string.faults_text) + String.valueOf(faultsTeamB);
        faultsView.setText(faultsMessage);
    }

    //Displays the serving team
    public void displayServeTeam(String serveTeam) {
        TextView serveView = (TextView) findViewById(R.id.servingTeam);
        String serveMessage = getString(R.string.serving_team_message, serveTeam);
        serveView.setText(serveMessage);
    }

    //Reset the scores and faults for both teams.
    public void resetScores(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        faultsTeamA = 0;
        faultsTeamB = 0;
        servingTeam = "A";
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayFaultsTeamA(faultsTeamA);
        displayFaultsTeamB(faultsTeamB);
    }
}
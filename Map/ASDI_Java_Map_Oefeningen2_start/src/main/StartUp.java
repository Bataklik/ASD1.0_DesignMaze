package main;

import domein.DomeinController;
import ui.BierApplicatie;

import java.io.IOException;

public class StartUp {
	public static void main(String[] args) throws IOException {
		DomeinController dc = new DomeinController();
		new BierApplicatie(dc).run();
	}
}

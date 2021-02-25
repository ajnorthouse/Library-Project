package com.cognixia.jump.library.helper;

import java.util.List;

import com.cognixia.jump.library.dao.LibrarianDAO;
import com.cognixia.jump.library.dao.PatronDAO;
import com.cognixia.jump.library.model.Librarian;
import com.cognixia.jump.library.model.Patron;

public class LoginHelper {
	
	public static int checkLogin(Librarian librarian, LibrarianDAO db) {
		List<Librarian> librarians = db.getAllLibrarians();
		
		for (Librarian lib : librarians) {
			
			//checks for equal usernames and passwords
			if (lib.getUsername().equals(librarian.getUsername())) {
				if (lib.getPassword().equals(librarian.getPassword())) {
					
					//returns id if both match
					return lib.getLibrarian_id();
				} else {
					
					//returns -1 if bad password
					return -1;
				}
			}
		}
		//returns 0 if the username doesn't exist
		return 0;
	}
	
	public static int checkLogin(Patron patron, PatronDAO db) {
		List<Patron> patrons = db.getAllPatrons();
		
		for (Patron pat : patrons) {
			
			//checks for matching usernames and passwords
			if (pat.getUsername().equals(patron.getUsername())) {
				if (pat.getPassword().equals(patron.getPassword())) {
					
					//returns id if both match
					return pat.getPatron_id();
				} else {
					
					//returns -1 if bad password
					return -1;
				}
			}
		}
		//returns 0 if the username doesn't exist
		return 0;
	}

}
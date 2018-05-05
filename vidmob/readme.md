AUTHOR
=========

Nata Vacheishvili
Worcester Polytechnic Institute
Worcester, MA
www.vache.me

OVERVIEW
==========

The project was developed for VidMob. The main purpose of the website was to
use HTML and CSS skills to implement a company sign up website pages for VidMob. 
In this documentation, I would like to further discuss information about each page
of the project in details.

The project assignment was divided into four parts: 
 - Default View
 - Existing Team
 - Non Existing Team
 - Error States

I united all the core concepts from the four parts and divided up the project
into three main parts:
 - Existing Company
 - New Company
 - Error States


Development
============
	The project folder contains 7 folders in total.
		1) css - Stores all of the stylesheets created.
		2) error-states - Stores all of the HTML files created according to Error States part of the assignment.
		3) existing-company - Stores the Existing Company HTML files created according to Existing Team part of the assignment.
		4) img - stores all of the images, logos and icons used for the web pages.
		5) js - stores all of the javascript files 
		6) new-company - Stores all of the HTML files created according to Non Existing Team part of the assignment. 

	Let's now discuss the 3 main parts of my implementation. 
	I. Existing Company
		This folder includes two files: 
			1) index.html
				index.html file is an implementation of "1 - Default View" from the assignment.
				The main purpose for this page was to be able to show a popup box displaying text to let the user know they need to confirm the email.
				For now, after closing the popup user is not being redirected to the second page included in this folder, called join-us.html
				The input email field is required, therefore form cannot be submitted without typing 
				valid email. 
				Form has a method of POST, therefore no information about the values of the fields
				will be displayed in the URL.
				QUESTIONS:
				What happens after user closes the popup ? As we are not working on the backend yet, we cannot wait for the link to be sent to them that could redirect them to the second state. Therefore should the user be redirected automatically after closing the popup? 

			2) join-us.html
				join-us.html is not connected with index.html contained in the same folder with any link. This page shows several input fields that are used to gain the information about the user. After submission, depending on the permissions of their company they will either automatically join their team or need to be invited.
				There are four input elements on this page. First Name, Last Name and Password fields are required therefore, it is impossible to submit the form without filling them out. 
				Display Name is optional. 
				Form has a method of POST as well, so no information about the input values will be displayed in the url after submitting. 

	II. New Company
		 This folder contains 3 files. 
		 	1) index.html
		 		In order to display the website with more flow and connect the chunks, I decided to add index.html page
		 		which has exactly the same design as the default view, however, when you press the button next it is going to redirect you on setup.html
		 		Index page assumes that user's email was not associated with any existing company in contrast with the index.html of Existing Company. 
		 	2) setup.html
		 		I created setup.html to complete the assignment part 3a - Non Existing: Setup. This page contains input fields to gain more information about the user. The form submit method is POST, so that all of the information gained after submitting the form is not displayed in the URL. First Name, Last NAme, Password and Company name fields are required. After user presses Sign Up Button they are redirected to sign-up.html page. 
		 	3) sign-up.html
		 		sign-up.html page is giving ability to the user to invite users to join the team or give other users with specified email domains join their team. On the press of each radio button, there is an input field where users can enter the email domains or invitations. The page is satisfying 3b,3c,3d and 3e parts of the assignment. 
				The tags input can hold one input on a line as required by 3c, it can hold two input fields on a single line as required by 3d and can also have multiple lines each having two entries. On a hover of the input field the text turns black. However, if user hovers on the X part, it will turn red as required by the design. 

	III. Error States
		This folder contains 


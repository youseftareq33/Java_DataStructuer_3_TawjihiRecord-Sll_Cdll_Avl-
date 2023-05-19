package application;
	
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent; 


public class A_DriverFX extends Application {
	
	
	
	// file
	static File f=null;
	
	static Text t2=new Text("");
	static Text t3=new Text("");
	
	
	// the main work
	static B_TawjihiDS t=new B_TawjihiDS();
	
	
	
	
	
	
	
	@Override
	public void start(Stage s){
		
		
		
		
		FileChooser fileChooser = new FileChooser();
        DropShadow shadow = new DropShadow();
        
        
        
        
        
        /************************************************************************************************************************************************************/
        /************************************************************************************************************************************************************/
        ///////////////////////////////////////////////////////////////// ffffirst scene(scene0) /////////////////////////////////////////////////////////////////////
        /************************************************************************************************************************************************************/
        /************************************************************************************************************************************************************/
        
        BorderPane bp=new BorderPane();
		Scene scene0 = new Scene(bp, 850, 540);
        
        
        
        ////////////////////////////sec 1 ///////////////////////////////
        //-------------------------------------------------------------//
        //-------------------------------------------------------------//
        //-------------------------------------------------------------//
        
        VBox vb01=new VBox();
        Label l01=new Label("     || Welcome to WestBank_TawjihiRecord_2020 Simulatour ||");
        l01.setPrefSize(460, 25);
		l01.setStyle("-fx-border-color: OLIVEDRAB;-fx-font-size:15;-fx-font-weight:bold;-fx-background-color: OLIVEDRAB;");
		vb01.getChildren().add(l01);
		vb01.setAlignment(Pos.TOP_CENTER);
        
        
        
        
        
        
        
        
        
        ////////////////////////////sec 2 ///////////////////////////////
        //-------------------------------------------------------------//
        //-------------------------------------------------------------//
        //-------------------------------------------------------------//
        HBox hbox02= new HBox();
        C_CDLinkedList cdl=new C_CDLinkedList<>();
    	int seat_num = 0;
    	String branch = null;
    	double avg = 0;
    	B_Student stud=new B_Student(seat_num, branch, avg);
        Text t02=new Text("Please choose the file you want: ");
        t02.setStyle("-fx-font-size:12;-fx-font-weight:bold;");
		t02.setFill(Color.BLACK);
        
		
		Label l02 = new Label();
		l02.setPrefSize(580, 54);
		l02.setStyle("-fx-background-color: white;-fx-Border-color: OLIVEDRAB;-fx-Border-width:5;"
				+ "-fx-font-size:15;-fx-font-weight:bold;-fx-text-fill: LIMEGREEN");

		//////////////////////// button load ///////////////////////////////
		Button b02 = new Button("Load");
		b02.setPrefSize(100, 43);
		b02.setStyle("-fx-background-color: White; -fx-background-radius: 10; -fx-Border-color: OLIVEDRAB;"
				+ "-fx-Border-radius: 7;-fx-font-size:20;-fx-Border-width:5;-fx-font-weight:bold; -fx-text-fill: LIMEGREEN");

		b02.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				b02.setEffect(shadow);
				b02.setStyle("-fx-background-color: OLIVEDRAB; -fx-background-radius: 10; -fx-Border-color: White;"
						+ "-fx-Border-radius: 7;-fx-font-size:20;-fx-Border-width:4;-fx-font-weight:bold; -fx-text-fill: white");
			}
		});
		b02.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				b02.setEffect(null);
				b02.setStyle("-fx-background-color: White; -fx-background-radius: 10; -fx-Border-color: OLIVEDRAB;"
						+ "-fx-Border-radius: 7;-fx-font-size:20;-fx-Border-width:5;-fx-font-weight:bold; -fx-text-fill: LIMEGREEN");
			}
		});

		//////////// set on action --------- Load ---------
		b02.setOnAction(load->{
			
			try {
				// to select a file.
	   		    File selectedFile = fileChooser.showOpenDialog(s);
	   		    f=selectedFile;
	   		 
	   		    // to show a path of a file.
	            String path= selectedFile.getAbsolutePath();
	        	l02.setText(" "+path);
			}
			catch(Exception l) {
				
			}
			
			
		});
		///////////////////////////////////////////////////////////////////

		hbox02.getChildren().addAll(l02, b02);

		hbox02.setSpacing(30);
        
		GridPane gp02=new GridPane();
		gp02.setVgap(28);
        gp02.setHgap(25);
		
        gp02.add(t02, 1, 1);
        gp02.add(hbox02, 1, 2);
        gp02.add(t2, 1, 3);
        gp02.add(t3, 1, 10);
        
        
        
        
        
        
		////////////////////////////sec 3 ///////////////////////////////
		//-------------------------------------------------------------//
		//-------------------------------------------------------------//
		//-------------------------------------------------------------//
		
		Text t03=new Text("Please choose the Branch you want:");
		t03.setStyle("-fx-font-size:12;-fx-font-weight:bold;");
		t03.setFill(Color.BLACK);
		
		
		
        RadioButton r0_31 = new RadioButton("Literary");
        RadioButton r0_32 = new RadioButton("Scientific");
       
        ToggleGroup tg03=new ToggleGroup();
        tg03.getToggles().add(r0_31);
        tg03.getToggles().add(r0_32);
 
		
        Button next03=new Button("next -->");
        next03.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
        next03.setPrefSize(70, 25);
        next03.setTextFill(Color.BLACK);
        
		next03.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				next03.setEffect(shadow);
				next03.setStyle("-fx-border-width: 2;-fx-background-color: Gold;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
				next03.setTextFill(Color.WHITE);
			}
		});
		next03.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				next03.setEffect(null);
				next03.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
				next03.setTextFill(Color.BLACK);
			}
		});
		
		
		
		
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		////////////set on action --------- next0 ---------
		
		
		next03.setOnAction(nextfirstscene->{
		
			
		//file------------
        if(f==null) {
        	Text errorfile_t2=new Text("  * Choose the file you want!!!");
    		errorfile_t2.setStyle("-fx-font-size:12;-fx-font-weight:bold;");
    		errorfile_t2.setFill(Color.RED); 
    		t2=errorfile_t2;
    		gp02.add(t2, 1, 3);
        }
        
        
		//branch------------
        if(r0_31.isSelected()!=true && r0_32.isSelected()!=true) {
        	Text errorBranch_t3=new Text("  * Choose the branch you want!!!");
    		errorBranch_t3.setStyle("-fx-font-size:12;-fx-font-weight:bold;");
    		errorBranch_t3.setFill(Color.RED);
    		t3=errorBranch_t3;
    		gp02.add(t3, 1, 10);
        }
		
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        
        if((f!=null) && (r0_31.isSelected()==true || r0_32.isSelected()==true)) {
          try {
          	// get data thats inside the file.
          	String x[]=null;
          	Scanner scan_tawjihi=new Scanner(f);
          	while(scan_tawjihi.hasNextLine()) {
			    x=scan_tawjihi.nextLine().split(",");
			     
			     if(r0_31.isSelected()==true && x[1].trim().equals("Literary")) {

				    t.insertStudentRecord(new B_Student(Integer.parseInt(x[0].trim()),x[1].trim(),Double.parseDouble(x[2].trim())));
				    
			    }
			    else if(r0_32.isSelected()==true && x[1].trim().equals("Scientific")) {
			    	
				    t.insertStudentRecord(new B_Student(Integer.parseInt(x[0].trim()),x[1].trim(),Double.parseDouble(x[2].trim())));
			    }
			}
          	
          
          }
  		catch(FileNotFoundException  e) {
  			System.out.println("hiiiiii");
  		}
          
          
          
          
          
          
          
          
          
          
          /************************************************************************************************************************************************************/
          /************************************************************************************************************************************************************/
          ///////////////////////////////////////////////////////////////// second scene(scene1) /////////////////////////////////////////////////////////////////////
          /************************************************************************************************************************************************************/
          /************************************************************************************************************************************************************/
          
          
  			GridPane gp10=new GridPane();
  			VBox vb10=new VBox();
  			Scene scene1=new Scene(vb10,850,540);
  			s.setScene(scene1);
  			
  			//vb2 style.
  			vb10.setSpacing(20);
  			vb10.setStyle("-fx-border-width: 2; -fx-border-color:FORESTGREEN; -fx-background-color:LIMEGREEN");
  			vb10.setPadding(new Insets(25,10,100,244));
  			
  			Button binsert=new Button("Insert New Tawjihi Record");
  			Button bupdate=new Button("Update A Tawjihi Record");
  			Button bdelete=new Button("Delete A Tawjihi Record");
  			Button bfind=new Button("Find A Tawjihi Record");
  			Button bgrade=new Button("Get All Student Using Specific Grade");
  			Button bad=new Button("Print Abstract Data Type");
  			Button bhavl=new Button("Print AVL Height");
  			Button breturn=new Button("Return To The Main Page");
//  			
//  			
  			//////////////////////////////////---------- inserrrrrrrtt --------------////////////////////////////////////////////////
  			// b1 style
  			binsert.setPrefSize(320, 43);
  			binsert.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: OLIVEDRAB;-fx-font-size:17;"
  					+ "-fx-Border-width:2;-fx-font-weight:bold;");
  			binsert.addEventHandler(MouseEvent.MOUSE_ENTERED,
  			        new EventHandler<MouseEvent>() {
  			          @Override
  			          public void handle(MouseEvent e) {
  			            binsert.setEffect(shadow);
  			            binsert.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: black;-fx-font-size:17;"
  			            		+ "-fx-Border-width:4;-fx-font-weight:bold;-fx-text-fill: white");
  			          }
  			        });
  			binsert.addEventHandler(MouseEvent.MOUSE_EXITED,
  			        new EventHandler<MouseEvent>() {
  			          @Override
  			          public void handle(MouseEvent e) {
  			            binsert.setEffect(null);
  			            binsert.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: OLIVEDRAB;-fx-font-size:17;"
  			            		+ "-fx-Border-width:2;-fx-font-weight:bold;");
  			          }
  			        });
  		
  			vb10.getChildren().add(binsert);
  			
  			
  	  			//////////////////////////////////---------- update --------------////////////////////////////////////////////////
  			bupdate.setPrefSize(320, 43);
  			bupdate.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: OLIVEDRAB;-fx-font-size:17;"
  					+ "-fx-Border-width:2;-fx-font-weight:bold;");
  			bupdate.addEventHandler(MouseEvent.MOUSE_ENTERED,
  			        new EventHandler<MouseEvent>() {
  			          @Override
  			          public void handle(MouseEvent e) {
  			        	bupdate.setEffect(shadow);
  			        	bupdate.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: black;-fx-font-size:17;"
  			            		+ "-fx-Border-width:4;-fx-font-weight:bold;-fx-text-fill: white");
  			          }
  			        });
  			bupdate.addEventHandler(MouseEvent.MOUSE_EXITED,
  			        new EventHandler<MouseEvent>() {
  			          @Override
  			          public void handle(MouseEvent e) {
  			        	bupdate.setEffect(null);
  			        	bupdate.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: OLIVEDRAB;-fx-font-size:17;"
  			            		+ "-fx-Border-width:2;-fx-font-weight:bold;");
  			          }
  			        });
  		
  			vb10.getChildren().add(bupdate);
  			
  			//////////////////////////////////---------- delllleeeete --------------////////////////////////////////////////////////
  			
  			bdelete.setPrefSize(320, 43);
  			bdelete.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: OLIVEDRAB;-fx-font-size:17;"
  					+ "-fx-Border-width:2;-fx-font-weight:bold;");
  			bdelete.addEventHandler(MouseEvent.MOUSE_ENTERED,
  			        new EventHandler<MouseEvent>() {
  			          @Override
  			          public void handle(MouseEvent e) {
  			        	bdelete.setEffect(shadow);
  			        	bdelete.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: black;-fx-font-size:17;"
  			            		+ "-fx-Border-width:4;-fx-font-weight:bold;-fx-text-fill: white");
  			          }
  			        });
  			bdelete.addEventHandler(MouseEvent.MOUSE_EXITED,
  			        new EventHandler<MouseEvent>() {
  			          @Override
  			          public void handle(MouseEvent e) {
  			        	bdelete.setEffect(null);
  			        	bdelete.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: OLIVEDRAB;-fx-font-size:17;"
  			            		+ "-fx-Border-width:2;-fx-font-weight:bold;");
  			          }
  			        });
  			vb10.getChildren().add(bdelete);


//  			//////////////////////////////////---------- find --------------////////////////////////////////////////////////
//  						
  			bfind.setPrefSize(320, 43);
  			bfind.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: OLIVEDRAB;-fx-font-size:17;"
  			+ "-fx-Border-width:2;-fx-font-weight:bold;");
  			bfind.addEventHandler(MouseEvent.MOUSE_ENTERED,
  			new EventHandler<MouseEvent>() {
  			@Override
  			public void handle(MouseEvent e) {
  				bfind.setEffect(shadow);
  				bfind.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: black;-fx-font-size:17;"
  			  		+ "-fx-Border-width:4;-fx-font-weight:bold;-fx-text-fill: white");
  			}
  			});
  			bfind.addEventHandler(MouseEvent.MOUSE_EXITED,
  			new EventHandler<MouseEvent>() {
  			@Override
  			public void handle(MouseEvent e) {
  				bfind.setEffect(null);
  				bfind.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: OLIVEDRAB;-fx-font-size:17;"
  			  		+ "-fx-Border-width:2;-fx-font-weight:bold;");
  			}
  			});
  			vb10.getChildren().add(bfind);


  			//////////////////////////////////---------- grade  --------------////////////////////////////////////////////////
  						
  			bgrade.setPrefSize(320, 43);
  			bgrade.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: OLIVEDRAB;-fx-font-size:17;"
  			+ "-fx-Border-width:2;-fx-font-weight:bold;");
  			bgrade.addEventHandler(MouseEvent.MOUSE_ENTERED,
  			new EventHandler<MouseEvent>() {
  			@Override
  			public void handle(MouseEvent e) {
  			bgrade.setEffect(shadow);
  			bgrade.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: black;-fx-font-size:17;"
  			+ "-fx-Border-width:4;-fx-font-weight:bold;-fx-text-fill: white");
  			}
  			});
  			bgrade.addEventHandler(MouseEvent.MOUSE_EXITED,
  			new EventHandler<MouseEvent>() {
  			@Override
  			public void handle(MouseEvent e) {
  			bgrade.setEffect(null);
  			bgrade.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: OLIVEDRAB;-fx-font-size:17;"
  			+ "-fx-Border-width:2;-fx-font-weight:bold;");
  			}
  			});
  			vb10.getChildren().add(bgrade);

  ////////////////////////////////////---------- print abstract data  --------------////////////////////////////////////////////////

				bad.setPrefSize(320, 43);
				bad.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: OLIVEDRAB;-fx-font-size:17;"
						+ "-fx-Border-width:2;-fx-font-weight:bold;");
				bad.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						bad.setEffect(shadow);
						bad.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: black;-fx-font-size:17;"
								+ "-fx-Border-width:4;-fx-font-weight:bold;-fx-text-fill: white");
					}
				});
				bad.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						bad.setEffect(null);
						bad.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: OLIVEDRAB;-fx-font-size:17;"
								+ "-fx-Border-width:2;-fx-font-weight:bold;");
					}
				});
				vb10.getChildren().add(bad);
  
				
				 ////////////////////////////////////---------- print height of tree  --------------////////////////////////////////////////////////

				bhavl.setPrefSize(320, 43);
				bhavl.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: OLIVEDRAB;-fx-font-size:17;"
						+ "-fx-Border-width:2;-fx-font-weight:bold;");
				bhavl.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						bhavl.setEffect(shadow);
						bhavl.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: black;-fx-font-size:17;"
								+ "-fx-Border-width:4;-fx-font-weight:bold;-fx-text-fill: white");
					}
				});
				bhavl.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						bhavl.setEffect(null);
						bhavl.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: OLIVEDRAB;-fx-font-size:17;"
								+ "-fx-Border-width:2;-fx-font-weight:bold;");
					}
				});
				vb10.getChildren().add(bhavl);
				
  			
  			//////////////////////////////////---------- return to main page  --------------////////////////////////////////////////////////
  						
  			breturn.setPrefSize(320, 43);
  			breturn.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: OLIVEDRAB;-fx-font-size:17;"
  			+ "-fx-Border-width:2;-fx-font-weight:bold;");
  			breturn.addEventHandler(MouseEvent.MOUSE_ENTERED,
  			new EventHandler<MouseEvent>() {
  			@Override
  			public void handle(MouseEvent e) {
  			breturn.setEffect(shadow);
  			breturn.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: black;-fx-font-size:17;"
  			+ "-fx-Border-width:4;-fx-font-weight:bold;-fx-text-fill: white");
  			}
  			});
  			breturn.addEventHandler(MouseEvent.MOUSE_EXITED,
  			new EventHandler<MouseEvent>() {
  			@Override
  			public void handle(MouseEvent e) {
  			breturn.setEffect(null);
  			breturn.setStyle("-fx-background-color: LAWNGREEN;-fx-Border-color: OLIVEDRAB;-fx-font-size:17;"
  			+ "-fx-Border-width:2;-fx-font-weight:bold;");
  			}
  			});
  			vb10.getChildren().add(breturn);
  			
  			////////////////////////
  			breturn.setOnAction(e9->{
  				s.setScene(scene0);
  				t.clearAllData(stud);
  				t2.setText("");
  				t3.setText("");
  				
  			});
  			////////////////////////////////////////////////////////////////////////////////////
  			/////////////////////////////////// Operation //////////////////////////////////////
  			////////////////////////////////////////////////////////////////////////////////////
          
  			// 1) insert
  			binsert.setOnAction(insert->{
  				
  				GridPane gpinsert=new GridPane();
  				Scene sceneadd=new Scene(gpinsert,850,540);
  				
  				gpinsert.setStyle("-fx-border-color:FORESTGREEN; -fx-background-color:LIMEGREEN;-fx-Border-width:2;");
  				gpinsert.setHgap(30);
  				gpinsert.setVgap(8);
  				
  				Text lins=new Text("Insert Operation");
  				lins.setStyle("-fx-font-size:25;-fx-font-weight:bold;");
  				gpinsert.add(lins,2,4);
  				
  				
  				Text pins=new Text("Please Enter Student Information:");
  				pins.setStyle("-fx-font-size:16;-fx-font-weight:bold;");
  				gpinsert.add(pins,2,9);
  				//////////////////////////////////
  				/////////////////////////////////
  				Text c0=new Text("Student Number :");
  				c0.setStyle("-fx-font-size:13;-fx-font-weight:bold;");
  				gpinsert.add(c0, 2, 13);
  				TextField ct0=new TextField();
  				ct0.setPromptText("123,(8-digit),....itc");
  				ct0.setStyle("-fx-border-width: 2; -fx-border-color: Black;");
  				gpinsert.add(ct0, 3, 13);
  				/////////////////////////////////
  				TextField ct1=new TextField();
  				
  				if(r0_31.isSelected()==true) {
  					ct1.setText("Literary");
  				}
  				else if(r0_32.isSelected()==true) {
  					ct1.setText("Scientific");
  				}
  				
  				/////////////////////////////////
  				Text c2=new Text("Student grade :");
				c2.setStyle("-fx-font-size:13;-fx-font-weight:bold;");
				gpinsert.add(c2, 2, 14);
  				TextField ct2=new TextField();
  				ct2.setPromptText("60,88,...itc");
				ct2.setStyle("-fx-border-width: 2; -fx-border-color: Black;");
				gpinsert.add(ct2, 3, 14);
  				///////////////////////////////////////////
  				///////////////////////////////////////////
				
				
				
  				Button b_insertl=new Button("Insert");
  				b_insertl.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
  				b_insertl.setPrefSize(70, 25);
  				b_insertl.setTextFill(Color.BLACK);
  		        
  				b_insertl.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
  					@Override
  					public void handle(MouseEvent e) {
  						b_insertl.setEffect(shadow);
  						b_insertl.setStyle("-fx-border-width: 2;-fx-background-color: Gold;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
  						b_insertl.setTextFill(Color.WHITE);
  					}
  				});
  				b_insertl.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
  					@Override
  					public void handle(MouseEvent e) {
  						b_insertl.setEffect(null);
  						b_insertl.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
  						b_insertl.setTextFill(Color.BLACK);
  					}
  				});
  				gpinsert.add(b_insertl, 6, 35);
  				gpinsert.setHalignment(b_insertl, HPos.RIGHT);
  				
  				
  				
  				Label er = new Label("");
  				er.setPrefSize(260, 60);
  		        gpinsert.add(er, 3, 17);
  				
  		        Label add = new Label("");
				add.setPrefSize(260, 60);
  		        gpinsert.add(add, 3, 17);
  				b_insertl.setOnAction(ac0->{
  				
  		        
  		        
						if (ct0.getText().equals("") == true || ct2.getText().equals("") == true) {
							er.setText("    Error:  please fill all the text fields  :*( ");
							er.setStyle(
									"-fx-border-color:FORESTGREEN;-fx-font-size:12;-fx-font-weight:bold;-fx-background-color: White;"
											+ "-fx-text-fill:#ff0000");
						}
						else {

							double snum = Double.parseDouble(ct0.getText());
							int gnum = Integer.parseInt(ct2.getText());

							if (snum < 0 || snum > 99999999) {
								er.setText(" Error: Invalid seat number(8 digit or less) :*( ");
								er.setStyle(
										"-fx-border-color:FORESTGREEN;-fx-font-size:12;-fx-font-weight:bold;-fx-background-color: White;"
												+ "-fx-text-fill:#ff0000");
								ct0.setText("");
								ct0.setPromptText("");
							} else {
								if (gnum < 0 || gnum > 100) {
									er.setText(" Error: Invalid grade value just(0 - 100) :*( ");
									er.setStyle(
											"-fx-border-color:FORESTGREEN;-fx-font-size:12;-fx-font-weight:bold;-fx-background-color: White;"
													+ "-fx-text-fill:#ff0000");
									ct2.setText("");
									ct2.setPromptText("");
								} else {

									if(snum==0) { // duplicated
										
									}
									else {
										
										B_Student studIns=new B_Student(0,null,0);
										studIns.setSeat_num(Integer.parseInt(ct0.getText()));
									    studIns.setBranch(ct1.getText());
									    studIns.setAvg(Double.parseDouble(ct2.getText()));
										t.insertStudentRecord(studIns);

										System.out.println("Insert Operation: " + ct0.getText() + "," + ct1.getText() + ","
												+ ct2.getText());

										ct0.setText("");
										ct2.setText("");
										ct0.setPromptText(" ");
										ct2.setPromptText(" ");
										ct0.setEditable(false);
										ct2.setEditable(false);

										add.setText("the Student was insert successfully : )");

										add.setStyle(
												"-fx-border-color:FORESTGREEN;-fx-font-size:12;-fx-font-weight:bold;-fx-background-color: White;"
														+ "-fx-text-fill:MEDIUMSPRINGGREEN");
										add.setAlignment(Pos.CENTER);
									}
									
								}
							}

						}
  		          	
  		          
  		           
  		           
  		          
  		          		
  				});
  				Button b_back=new Button("<-- Back");
  				b_back.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
  				b_back.setPrefSize(70, 25);
  				b_back.setTextFill(Color.BLACK);
  		        
  				b_back.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
  					@Override
  					public void handle(MouseEvent e) {
  						b_back.setEffect(shadow);
  						b_back.setStyle("-fx-border-width: 2;-fx-background-color: Gold;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
  						b_back.setTextFill(Color.WHITE);
  					}
  				});
  				b_back.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
  					@Override
  					public void handle(MouseEvent e) {
  						b_back.setEffect(null);
  						b_back.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
  						b_back.setTextFill(Color.BLACK);
  					}
  				});
  				gpinsert.add(b_back, 5, 35);
  				b_back.setOnAction(e12->{
  					s.setScene(scene1);
  				});
  				gpinsert.setHalignment(b_back, HPos.CENTER);
  				s.setScene(sceneadd);
  			});
  			
  			
  			
  			
  			
  			
  			
  			
  			
  			
  			
  			
  			//2 update
  			bupdate.setOnAction(update->{
  				
  				
  			GridPane gpupdate=new GridPane();
  			Scene sceneupdate=new Scene(gpupdate,850,540);
  			gpupdate.setStyle("-fx-border-color:FORESTGREEN; -fx-background-color:LIMEGREEN;-fx-Border-width:2;");
  			gpupdate.setHgap(30);
  			gpupdate.setVgap(8);
  			s.setScene(sceneupdate);
  			
  			Text lins=new Text("Update Operation");
			lins.setStyle("-fx-font-size:25;-fx-font-weight:bold;");
			gpupdate.add(lins,2,4);
				
				
			Text pins=new Text("Please enter student number:");
			pins.setStyle("-fx-font-size:16;-fx-font-weight:bold;");
			gpupdate.add(pins,2,9);
			
			
  			
  			
  			
  			Text s_id=new Text("Student Number : ");
  			s_id.setStyle("-fx-font-size:12;-fx-font-weight:bold;");
  			gpupdate.add(s_id, 2, 13);
  			
  			TextField ct0=new TextField();
  			ct0.setPromptText("123,(8-digit),....itc");
  			ct0.setStyle("-fx-border-width: 2; -fx-border-color: Black;");
  			gpupdate.add(ct0, 3, 13);
  			
  			

  			
  			
  			
  			
  			
  			
  			Button b_update1_next=new Button("Next -->");
  			b_update1_next.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
  			b_update1_next.setPrefSize(70, 25);
  			b_update1_next.setTextFill(Color.BLACK);
	        
  			b_update1_next.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					b_update1_next.setEffect(shadow);
					b_update1_next.setStyle("-fx-border-width: 2;-fx-background-color: Gold;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
					b_update1_next.setTextFill(Color.WHITE);
				}
			});
  			b_update1_next.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					b_update1_next.setEffect(null);
					b_update1_next.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
					b_update1_next.setTextFill(Color.BLACK);
				}
			});
  			gpupdate.add(b_update1_next, 6,35);
  			gpupdate.setHalignment(b_update1_next, HPos.RIGHT);
  			
  			
  			
  			
  			
  			
  			
  			Button b_back=new Button("<-- Back");
  			b_back.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
			b_back.setPrefSize(70, 25);
			b_back.setTextFill(Color.BLACK);
	        
			b_back.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					b_back.setEffect(shadow);
					b_back.setStyle("-fx-border-width: 2;-fx-background-color: Gold;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
					b_back.setTextFill(Color.WHITE);
				}
			});
			b_back.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					b_back.setEffect(null);
					b_back.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
					b_back.setTextFill(Color.BLACK);
				}
			});
  			gpupdate.add(b_back, 5, 35);
  			gpupdate.setHalignment(b_back, HPos.CENTER);
  			b_back.setOnAction(kl->{
  				s.setScene(scene1);
  			});
  			
  			

  			
  			
  			
  			
  				Label er = new Label("");
  				er.setText("                                            ");
  				er.setPrefSize(260, 60);
	                
					gpupdate.add(er, 3, 14);
				
				
				b_update1_next.setOnAction(n->{
  						
  						if(ct0.getText().equals("")==true) {
  							er.setPrefSize(260, 60);
  							er.setText("    Error:  please fill the text field  :*( ");
  							er.setStyle("-fx-border-color:FORESTGREEN;-fx-font-size:12;-fx-font-weight:bold;-fx-background-color: White;"
  									+ "-fx-text-fill:#ff0000");
  						}
  						else {
  							double snum = Double.parseDouble(ct0.getText());
  							if (snum < 0 || snum > 99999999) {
								er.setText(" Error: Invalid seat number(8 digit or less) :*( ");
								er.setStyle(
										"-fx-border-color:FORESTGREEN;-fx-font-size:12;-fx-font-weight:bold;-fx-background-color: White;"
												+ "-fx-text-fill:#ff0000");
								ct0.setText("");
								ct0.setPromptText("");
							}
  							else {
  	  							GridPane gpupdatenext=new GridPane();
  	  	  						gpupdatenext.setStyle("-fx-border-color:FORESTGREEN; -fx-background-color:LIMEGREEN;-fx-Border-width:2;");
  	  	  						gpupdatenext.setHgap(30);
  	  	  						gpupdatenext.setVgap(8);
  	  	  						Scene gps=new Scene(gpupdatenext,850,540);
  	  	  						s.setScene(gps);
  	  	  						
  	  	  						
  	  	  						Text lins1=new Text("Update Operation");
  	  	  						lins1.setStyle("-fx-font-size:25;-fx-font-weight:bold;");
  	  	  						gpupdatenext.add(lins1,2,4);
  	  	  					
  	  	  					
  	  	  						Text pins1=new Text("Please Enter Student Information:");
  	  	  						pins1.setStyle("-fx-font-size:16;-fx-font-weight:bold;");
  	  	  						gpupdatenext.add(pins1,2,9);
  	  	  						
  	  	  						/////////////////////////////////
  	  							Text c0 = new Text("Student Branch :");
  	  							c0.setStyle("-fx-font-size:13;-fx-font-weight:bold;");
  	  							gpupdatenext.add(c0, 2, 13);
  	  							
  	  							ComboBox<String> cb7=new ComboBox<>();
  	  							cb7.getItems().addAll("Literary","Scientific");
  	  							gpupdatenext.add(cb7, 3, 13);
  	  							/////////////////////////////////
  	  							Text c1 = new Text("Student average :");
  	  							c1.setStyle("-fx-font-size:13;-fx-font-weight:bold;");
  	  							gpupdatenext.add(c1, 2, 14);
  	  							TextField ct1u = new TextField();
  	  							ct1u.setPromptText("60,88,...itc");
  	  							ct1u.setStyle("-fx-border-width: 2; -fx-border-color: Black;");
  	  							gpupdatenext.add(ct1u, 3, 14);
  	  							/////////////////////////////////////////
  	  							
  	  							///////////////////////////////////////////
  	  	  						
  	  	  						Button bupn=new Button("Update");
  	  	  						
  	  	  						bupn.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
  	  	  						bupn.setPrefSize(70, 25);
  	  	  						bupn.setTextFill(Color.BLACK);
  	 	  					bupn.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
  								@Override
  								public void handle(MouseEvent e) {
  									bupn.setEffect(shadow);
  									bupn.setStyle("-fx-border-width: 2;-fx-background-color: Gold;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
  									bupn.setTextFill(Color.WHITE);
  								}
  							});
  	 	  					bupn.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
  								@Override
  								public void handle(MouseEvent e) {
  									bupn.setEffect(null);
  									bupn.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
  									bupn.setTextFill(Color.BLACK);
  								}
  							});	
  	 	  					gpupdatenext.add(bupn, 6, 35);
  	  	  			  		gpupdatenext.setHalignment(bupn, HPos.RIGHT);
  	  	  					
  	  	  			  		
  	  	  			  		Label eru = new Label("");
  	  	  			  		eru.setText("                                            ");
  	  	  			  		eru.setPrefSize(260, 60);
  	  	  			  		gpupdatenext.add(eru, 3, 15);
  	  	  			  		
  	  	  			  		
  	  	  			  		Label add = new Label("");
  	  	  			  		add.setPrefSize(260, 60);
  	  	  			  		gpupdatenext.add(add, 3, 15);
  	  	  			  		
  	  	  			  		bupn.setOnAction(eq->{
  	  	  			  		String ct0u=cb7.getSelectionModel().getSelectedItem();
  	  	  			  		if(ct0u==null) {
  	  	  			  	
							eru.setText("    Error:  please select the Branch :*( ");
							eru.setStyle("-fx-border-color:FORESTGREEN;-fx-font-size:12;-fx-font-weight:bold;-fx-background-color: White;"
									+ "-fx-text-fill:#ff0000");
  	  	  			  		}
  	  	  			  		else {
  	  	  			  			if(ct1u.getText().equals("")==true) {
  	    	  				
	  							eru.setText("    Error:  please fill the text fields  :*( ");
	  							eru.setStyle("-fx-border-color:FORESTGREEN;-fx-font-size:12;-fx-font-weight:bold;-fx-background-color: White;"
	  									+ "-fx-text-fill:#ff0000");
	  						}
	  	  			  		else {
	  	  			  			
	  	  			  	double gnum = Double.parseDouble(ct1u.getText());
	  	  			  		if (gnum < 0 || gnum > 100) {
								eru.setText(" Error: Invalid grade value just(0 - 100) :*( ");
								eru.setStyle(
										"-fx-border-color:FORESTGREEN;-fx-font-size:12;-fx-font-weight:bold;-fx-background-color: White;"
												+ "-fx-text-fill:#ff0000");
								ct1u.setText("");
								ct1u.setPromptText("");
							}
	  	  			  			else {
	  	  			  			System.out.println("Update Operation: the Student who have Seat Number: "+ct0.getText()
  	  			  				+ " --> "+ct0.getText()+","+ct0u+","+ct1u.getText());
	  	  			  			B_Student studUpdate=new B_Student(0,null,0);
	  	  			  			studUpdate.setSeat_num(Integer.parseInt(ct0.getText()));
	  	  			  			studUpdate.setBranch(ct0u);
	  	  			  			studUpdate.setAvg(gnum);
	  	  			  			
	  	  			  			t.updateStudentRecord(studUpdate);
	  	  			  			
  	  			  		  	cb7.setSelectionModel(null);
  	  			  			ct1u.setText("");
  	  			  			ct1u.setPromptText(" ");
  	  			  			ct1u.setEditable(false);
		                  
			            	add.setText("the Student was updated successfully : )");
							
							add.setStyle("-fx-border-color:FORESTGREEN;-fx-font-size:12;-fx-font-weight:bold;-fx-background-color: White;"
									+ "-fx-text-fill:MEDIUMSPRINGGREEN");
							add.setAlignment(Pos.CENTER);
	  	  			  			}
	  	  			  		
	  	  			  		}
  	  	  			  		}
  	  	  			  		
  	  	  			  		});

  	  	  			  		
  	  	  			  		
  	  	  					Button b_backu=new Button("<-- Back");
  							b_backu.setPrefSize(70, 25);
  							b_backu.setTextFill(Color.BLACK);
  							b_backu.setStyle("-fx-border-width: 2;-fx-background-color: Gold;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
  							
  							b_backu.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
  								@Override
  								public void handle(MouseEvent e) {
  									b_backu.setEffect(shadow);
  									b_backu.setStyle("-fx-border-width: 2;-fx-background-color: Gold;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
  									b_backu.setTextFill(Color.WHITE);
  								}
  							});
  							b_backu.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
  								@Override
  								public void handle(MouseEvent e) {
  									b_backu.setEffect(null);
  									b_backu.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
  									b_backu.setTextFill(Color.BLACK);
  								}
  							});
  	  	  			  		gpupdatenext.add(b_backu, 5, 35);
  	  	  			  		gpupdatenext.setHalignment(b_backu, HPos.CENTER);
  	  	  			  			b_backu.setOnAction(khjl->{
  	  	  			  				er.setText("");
  	  	  			  				er.setStyle("");
  	  	  			  				s.setScene(sceneupdate);
  	  	  			  			});
  	  						}
  						}
  						
  						
  			
  			});
  			
  			});
  			
  			//3 Delete
  			
  			bdelete.setOnAction(edel->{
  				GridPane gpdelete=new GridPane();
  			Scene scenedelete=new Scene(gpdelete,850,540);
  			gpdelete.setStyle("-fx-border-color:FORESTGREEN; -fx-background-color:LIMEGREEN;-fx-Border-width:2;");
  			gpdelete.setHgap(30);
  			gpdelete.setVgap(8);
  			s.setScene(scenedelete);
  			
  			Text lins=new Text("Delete Operation");
			lins.setStyle("-fx-font-size:25;-fx-font-weight:bold;");
			gpdelete.add(lins,2,4);
				
				
			Text pins=new Text("Please enter student number:");
			pins.setStyle("-fx-font-size:16;-fx-font-weight:bold;");
			gpdelete.add(pins,2,9);
			
			
  			
  			
  			
  			Text s_id=new Text("Student Number : ");
  			s_id.setStyle("-fx-font-size:12;-fx-font-weight:bold;");
  			gpdelete.add(s_id, 2, 13);
  			
  			TextField ct0=new TextField();
  			ct0.setPromptText("123,(8-digit),....itc");
  			ct0.setStyle("-fx-border-width: 2; -fx-border-color: Black;");
  			gpdelete.add(ct0, 3, 13);
  			
  			

  			
  			
  			
  			
  			
  			
  			Button del=new Button("Delete");
  			del.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
  			del.setPrefSize(70, 25);
  			del.setTextFill(Color.BLACK);
	        
  			del.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					del.setEffect(shadow);
					del.setStyle("-fx-border-width: 2;-fx-background-color: Gold;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
					del.setTextFill(Color.WHITE);
				}
			});
  			del.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					del.setEffect(null);
					del.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
					del.setTextFill(Color.BLACK);
				}
			});
  			gpdelete.add(del, 6,35);
  			gpdelete.setHalignment(del, HPos.RIGHT);
  			
  			Label er = new Label("");
            er.setPrefSize(260, 60);
	        gpdelete.add(er, 3, 14);
			
	        Label add = new Label("");
	        gpdelete.add(add, 3, 14);
			del.setOnAction(ac0->{
			
	         
	          	if (ct0.getText().equals("") == true) {
		                er.setText("    Error:  please fill the text field  :*( ");
						er.setStyle("-fx-border-color:FORESTGREEN;-fx-font-size:12;-fx-font-weight:bold;-fx-background-color: White;"
								+ "-fx-text-fill:#ff0000");
		            }
	          	else {
	          		
	          		B_Student studdel=t.findStudentRecord(Integer.parseInt(ct0.getText()));
	          		t.deleteStudentRecord(studdel);
	          		
                  System.out.println("Delete Operation: "+"the Student who have seat number: "+ct0.getText()+" Deleted successfully");
                  
                  
                  
                  
					  ct0.setText("");
	                  ct0.setPromptText(" ");
	                  ct0.setEditable(false);
	                  
		            	add.setText("the Student was Deleted successfully : )");
						add.setPrefSize(260, 60);
						
						add.setStyle("-fx-border-color:FORESTGREEN;-fx-font-size:12;-fx-font-weight:bold;-fx-background-color: White;"
								+ "-fx-text-fill:MEDIUMSPRINGGREEN");
						add.setAlignment(Pos.CENTER);
		            }
			});
  			
  			
  			
  			
  			Button b_back=new Button("<-- Back");
  			b_back.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
			b_back.setPrefSize(70, 25);
			b_back.setTextFill(Color.BLACK);
	        
			b_back.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					b_back.setEffect(shadow);
					b_back.setStyle("-fx-border-width: 2;-fx-background-color: Gold;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
					b_back.setTextFill(Color.WHITE);
				}
			});
			b_back.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					b_back.setEffect(null);
					b_back.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
					b_back.setTextFill(Color.BLACK);
				}
			});
  			gpdelete.add(b_back, 5, 35);
  			gpdelete.setHalignment(b_back, HPos.CENTER);
  			b_back.setOnAction(kl->{
  				s.setScene(scene1);
  			});

  			});
  			
  			
  			
  			
  			
  			
  			
  			
  			
  			
  			
  			
  			// find
  			
  			bfind.setOnAction(efind->{
  			GridPane gpfind=new GridPane();
  			Scene scenefind=new Scene(gpfind,850,540);
  			gpfind.setStyle("-fx-border-color:FORESTGREEN; -fx-background-color:LIMEGREEN;-fx-Border-width:2;");
  			gpfind.setHgap(30);
  			gpfind.setVgap(8);
  			
  			Text lins=new Text("Find Operation");
			lins.setStyle("-fx-font-size:25;-fx-font-weight:bold;");
			gpfind.add(lins,2,4);
				
				
			Text pins=new Text("Please enter student number:");
			pins.setStyle("-fx-font-size:16;-fx-font-weight:bold;");
			gpfind.add(pins,2,9);
			
  			Text s_id=new Text("Student Number : ");
  			s_id.setStyle("-fx-font-size:12;-fx-font-weight:bold;");
  			gpfind.add(s_id, 2, 13);
  			TextField ct0=new TextField();
  			ct0.setPromptText("123,(8-digit),....itc");
  			ct0.setStyle("-fx-border-width: 2; -fx-border-color: Black;");
  			gpfind.add(ct0, 3, 13);
  			
  			
  			Button b_find_next=new Button("Next -->");
  			b_find_next.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
			b_find_next.setPrefSize(70, 25);
			b_find_next.setTextFill(Color.BLACK);
	        
			b_find_next.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					b_find_next.setEffect(shadow);
					b_find_next.setStyle("-fx-border-width: 2;-fx-background-color: Gold;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
					b_find_next.setTextFill(Color.WHITE);
				}
			});
			b_find_next.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					b_find_next.setEffect(null);
					b_find_next.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
					b_find_next.setTextFill(Color.BLACK);
				}
			});
  			gpfind.add(b_find_next, 6,35);
  			gpfind.setHalignment(b_find_next, HPos.RIGHT);
  			b_find_next.setOnAction(n->{
  				
  					Label er = new Label("");
  					gpfind.add(er, 3, 14);
  					B_Student studfind=t.findStudentRecord(Integer.parseInt(ct0.getText()));
  					if (ct0.getText().equals("") == true) {
  						 er.setText("    Error:  please fill the text field  :*( ");
 		                er.setPrefSize(260, 60);
 						er.setStyle("-fx-border-color:FORESTGREEN;-fx-font-size:12;-fx-font-weight:bold;-fx-background-color: White;"
 								+ "-fx-text-fill:#ff0000");
  			      }
  					if(studfind==null) {
  						
  						 er.setText("Error: there is no student have this seat number");
  			              er.setPrefSize(290, 60);
  							er.setStyle("-fx-border-color: DARKCYAN;-fx-font-size:12;-fx-font-weight:bold;-fx-background-color: White;"
  									+ "-fx-text-fill:#ff0000");
  					}
  					else {
  						////////////////////////////////////////////////////////////////////////
  						GridPane gpnextfind=new GridPane();
  						gpnextfind.setStyle("-fx-border-color:FORESTGREEN; -fx-background-color:LIMEGREEN;-fx-Border-width:2;");
  						Scene scenenextfind=new Scene(gpnextfind,850,540);
  						gpnextfind.setHgap(30);
  						gpnextfind.setVgap(8);
  						Text p_id=new Text("Student information");
  						p_id.setStyle("-fx-font-size:12;-fx-font-weight:bold;");
  						gpnextfind.add(p_id, 2, 1);
  						TextArea ta=new TextArea();
  					    ta.setText("     "+studfind.toString());
  						ta.setStyle("-fx-border-color:FORESTGREEN;");
  						ta.setWrapText(true);
  						ta.setEditable(false);////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  						
  						gpnextfind.add(ta, 2, 4);
  						
  						Button b_back=new Button("<-- Back");
  						b_back.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
  						b_back.setPrefSize(70, 25);
  						b_back.setTextFill(Color.BLACK);
  				        
  						b_back.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
  							@Override
  							public void handle(MouseEvent e) {
  								b_back.setEffect(shadow);
  								b_back.setStyle("-fx-border-width: 2;-fx-background-color: Gold;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
  								b_back.setTextFill(Color.WHITE);
  							}
  						});
  						b_back.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
  							@Override
  							public void handle(MouseEvent e) {
  								b_back.setEffect(null);
  								b_back.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
  								b_back.setTextFill(Color.BLACK);
  							}
  						});
  						gpnextfind.add(b_back, 5, 35);
  						gpnextfind.setHalignment(b_back, HPos.LEFT);
  						
  						b_back.setOnAction(searchbacccc->{
  						s.setScene(scenefind);
  						});
  						
  						s.setScene(scenenextfind);
  					}
  				
  				
  				
  				
  			});
  			
  			Button b_back=new Button("<-- Back");
  			b_back.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
				b_back.setPrefSize(70, 25);
				b_back.setTextFill(Color.BLACK);
		        
				b_back.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						b_back.setEffect(shadow);
						b_back.setStyle("-fx-border-width: 2;-fx-background-color: Gold;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
						b_back.setTextFill(Color.WHITE);
					}
				});
				b_back.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						b_back.setEffect(null);
						b_back.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
						b_back.setTextFill(Color.BLACK);
					}
				});
  			gpfind.add(b_back, 5, 35);
  			b_back.setOnAction(kl->{
  				s.setScene(scene1);
  			});
  			gpfind.setHalignment(b_back, HPos.CENTER);
  			//
  			s.setScene(scenefind);
  			});
  			
  			
  			
  			
  			
  			
  			
  			
  			
  			
  			
  			
  			
  			
  			
  			
  			//grade
  			
  			bgrade.setOnAction(egrade->{
  				BorderPane bpgrade=new BorderPane();
  				GridPane gpgrade=new GridPane();
  	  			Scene scenegrade=new Scene(bpgrade,850,540);
  	  			bpgrade.setStyle("-fx-border-color:FORESTGREEN; -fx-background-color:LIMEGREEN;-fx-Border-width:2;");
  	  			gpgrade.setHgap(30);
  	  			gpgrade.setVgap(8);
  	  			
  	  			VBox vgrade=new VBox();
  	  			
  	  			bpgrade.setTop(vgrade);
  	  			bpgrade.setCenter(gpgrade);
  	  			
  	  			Text lins=new Text("\n"+"        Get Student Using Specific Grade Operation");
  				lins.setStyle("-fx-font-size:25;-fx-font-weight:bold;");
  				gpgrade.add(lins,2,4);
  				
  				vgrade.getChildren().add(lins);
  					
  				Text pins=new Text("\nPlease enter the grade:");
  				pins.setStyle("-fx-font-size:16;-fx-font-weight:bold;");
  				gpgrade.add(pins,2,9);
  				
  	  			Text s_id=new Text("grade : ");
  	  			s_id.setStyle("-fx-font-size:12;-fx-font-weight:bold;");
  	  			gpgrade.add(s_id, 2, 13);
  	  			TextField ct0=new TextField();
  	  			ct0.setPromptText("60,88,...itc");
  	  			ct0.setStyle("-fx-border-width: 2; -fx-border-color: Black;");
  	  			gpgrade.add(ct0, 3, 13);
  	  			
  	  			
  	  			Button b_find_next=new Button("Next -->");
  	  			b_find_next.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
  				b_find_next.setPrefSize(70, 25);
  				b_find_next.setTextFill(Color.BLACK);
  		        
  				b_find_next.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
  					@Override
  					public void handle(MouseEvent e) {
  						b_find_next.setEffect(shadow);
  						b_find_next.setStyle("-fx-border-width: 2;-fx-background-color: Gold;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
  						b_find_next.setTextFill(Color.WHITE);
  					}
  				});
  				b_find_next.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
  					@Override
  					public void handle(MouseEvent e) {
  						b_find_next.setEffect(null);
  						b_find_next.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
  						b_find_next.setTextFill(Color.BLACK);
  					}
  				});
  				gpgrade.add(b_find_next, 6,35);
  				gpgrade.setHalignment(b_find_next, HPos.RIGHT);
  	  			b_find_next.setOnAction(n->{
  	  				
  	  					Label er = new Label("");
  	  					gpgrade.add(er, 3, 14);
  	  					if (ct0.getText().equals("") == true) {
  	  						 er.setText("    Error:  please fill the text field  :*( ");
  	 		                er.setPrefSize(260, 60);
  	 						er.setStyle("-fx-border-color:FORESTGREEN;-fx-font-size:12;-fx-font-weight:bold;-fx-background-color: White;"
  	 								+ "-fx-text-fill:#ff0000");
  	  			      }

  	  					else {
  	  						////////////////////////////////////////////////////////////////////////
  	  						GridPane gpnextfind=new GridPane();
  	  						gpnextfind.setStyle("-fx-border-color:FORESTGREEN; -fx-background-color:LIMEGREEN;-fx-Border-width:2;");
  	  						Scene scenenextfind=new Scene(gpnextfind,850,540);
  	  						gpnextfind.setHgap(30);
  	  						gpnextfind.setVgap(8);
  	  						Text p_id=new Text("Student information");
  	  						p_id.setStyle("-fx-font-size:12;-fx-font-weight:bold;");
  	  						gpnextfind.add(p_id, 2, 1);
  	  						F_SLinkedList l=t.getAllStudentRecord_SpAvg(Double.parseDouble(ct0.getText()));
  	  						TextArea ta=new TextArea();
  	  						ta.setText("     "+l.toString());
  	  						ta.setStyle("-fx-border-color:FORESTGREEN;");
  	  						ta.setWrapText(true);
  	  						ta.setEditable(false);////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  	  						
  	  						gpnextfind.add(ta, 2, 4);
  	  						
  	  						Button b_back=new Button("<-- Back");
  	  						b_back.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
  	  						b_back.setPrefSize(70, 25);
  	  						b_back.setTextFill(Color.BLACK);
  	  				        
  	  						b_back.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
  	  							@Override
  	  							public void handle(MouseEvent e) {
  	  								b_back.setEffect(shadow);
  	  								b_back.setStyle("-fx-border-width: 2;-fx-background-color: Gold;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
  	  								b_back.setTextFill(Color.WHITE);
  	  							}
  	  						});
  	  						b_back.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
  	  							@Override
  	  							public void handle(MouseEvent e) {
  	  								b_back.setEffect(null);
  	  								b_back.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
  	  								b_back.setTextFill(Color.BLACK);
  	  							}
  	  						});
  	  						gpnextfind.add(b_back, 5, 35);
  	  						gpnextfind.setHalignment(b_back, HPos.LEFT);
  	  						
  	  						b_back.setOnAction(searchbacccc->{
  	  						s.setScene(scenegrade);
  	  						});
  	  						
  	  						s.setScene(scenenextfind);
  	  					}
  	  				
  	  				
  	  				
  	  				
  	  			});
  	  			
  	  			Button b_back=new Button("<-- Back");
  	  			b_back.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
  					b_back.setPrefSize(70, 25);
  					b_back.setTextFill(Color.BLACK);
  			        
  					b_back.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
  						@Override
  						public void handle(MouseEvent e) {
  							b_back.setEffect(shadow);
  							b_back.setStyle("-fx-border-width: 2;-fx-background-color: Gold;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
  							b_back.setTextFill(Color.WHITE);
  						}
  					});
  					b_back.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
  						@Override
  						public void handle(MouseEvent e) {
  							b_back.setEffect(null);
  							b_back.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
  							b_back.setTextFill(Color.BLACK);
  						}
  					});
  				gpgrade.add(b_back, 5, 35);
  	  			b_back.setOnAction(kl->{
  	  				s.setScene(scene1);
  	  			});
  	  			gpgrade.setHalignment(b_back, HPos.CENTER);
  	  			//
  	  			s.setScene(scenegrade);
  			});
  			
  			
  			
  			
  			
  			
  			
  			
  			
  			
  			
  			
  			
  			// print abstract data
  			bad.setOnAction(ead->{
  				BorderPane bpad=new BorderPane();
				bpad.setStyle("-fx-border-color:FORESTGREEN; -fx-background-color:LIMEGREEN;-fx-Border-width:2;");
				Scene scenead=new Scene(bpad,850,540);
				s.setScene(scenead);
				
				HBox had=new HBox();
				
				VBox va=new VBox();
				Text ta=new Text("Print Abstract Data Operation");
				ta.setStyle("-fx-font-size:25;-fx-font-weight:bold;");
				
				Text ta2=new Text("Please select abstract data: ");
				ta2.setStyle("-fx-font-size:16;-fx-font-weight:bold;");
				
				va.getChildren().addAll(ta,ta2);
				va.setTranslateX(25);
				va.setTranslateY(50);
				va.setSpacing(50);
				
				had.setTranslateX(47);
				had.setTranslateY(80);
				had.setSpacing(30);
				
				
				HBox hback=new HBox();
				hback.setTranslateX(750);
				hback.setTranslateY(-25);
				
				
				bpad.setTop(va);
				bpad.setCenter(had);
				bpad.setBottom(hback);
				
				
				
				
				
				// buttons
				Button bhad_Dll=new Button("Double Linked List");
				bhad_Dll.setPrefSize(220, 220);
				bhad_Dll.setStyle("-fx-background-color: White; -fx-background-radius: 115; -fx-Border-color: OLIVEDRAB;"
						+ "-fx-Border-radius: 112;-fx-font-size:20;-fx-Border-width:5;-fx-font-weight:bold; -fx-text-fill: LIMEGREEN");
		
				bhad_Dll.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						bhad_Dll.setEffect(shadow);
						bhad_Dll.setStyle("-fx-background-color: OLIVEDRAB; -fx-background-radius: 115; -fx-Border-color: White;"
								+ "-fx-Border-radius: 112;-fx-font-size:20;-fx-Border-width:4;-fx-font-weight:bold; -fx-text-fill: white");
					}
				});
				bhad_Dll.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						bhad_Dll.setEffect(null);
						bhad_Dll.setStyle("-fx-background-color: White; -fx-background-radius: 115; -fx-Border-color: OLIVEDRAB;"
								+ "-fx-Border-radius: 112;-fx-font-size:20;-fx-Border-width:5;-fx-font-weight:bold; -fx-text-fill: LIMEGREEN");
					}
				});
				
				bhad_Dll.setOnAction(ed->{
					
					GridPane gpp1=new GridPane();
					gpp1.setStyle("-fx-border-color:FORESTGREEN; -fx-background-color:LIMEGREEN;-fx-Border-width:2;");
					Scene scenenp1=new Scene(gpp1,850,540);
					gpp1.setHgap(30);
					gpp1.setVgap(8);
					
	  			    Text lins=new Text("Print Abstract Data Operation");
					lins.setStyle("-fx-font-size:25;-fx-font-weight:bold;");
					gpp1.add(lins,2,4);
						
						
					Text pins=new Text("Double Linked List:");
					pins.setStyle("-fx-font-size:16;-fx-font-weight:bold;");
					gpp1.add(pins,2,11);
					
					
					TextArea ta1=new TextArea();
					ta1.setText(t.printdoublelinkedlist());
					
					
					ta1.setPrefSize(570, 320);
					ta1.setStyle("-fx-border-color:FORESTGREEN;");
					ta1.setWrapText(true);
					ta1.setEditable(false);////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					
					gpp1.add(ta1, 2, 12);
					
					Button b_back=new Button("<-- Back");
					b_back.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
					b_back.setPrefSize(70, 25);
					b_back.setTextFill(Color.BLACK);
			        
					b_back.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent e) {
							b_back.setEffect(shadow);
							b_back.setStyle("-fx-border-width: 2;-fx-background-color: Gold;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
							b_back.setTextFill(Color.WHITE);
						}
					});
					b_back.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent e) {
							b_back.setEffect(null);
							b_back.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
							b_back.setTextFill(Color.BLACK);
						}
					});
					gpp1.add(b_back, 6, 13);
					//gpp1.setHalignment(b_back, HPos.LEFT);
					
					b_back.setOnAction(searchbacccc->{
					s.setScene(scenead);
					});
					
					s.setScene(scenenp1);
				});
				
				
				
				
				Button bhad_1a=new Button("       1st AVL"+"\n"
						+ "(level-traversal)");
				bhad_1a.setPrefSize(220, 220);
				bhad_1a.setStyle("-fx-background-color: White; -fx-background-radius: 115; -fx-Border-color: OLIVEDRAB;"
						+ "-fx-Border-radius: 112;-fx-font-size:20;-fx-Border-width:5;-fx-font-weight:bold; -fx-text-fill: LIMEGREEN");
		
				bhad_1a.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						bhad_1a.setEffect(shadow);
						bhad_1a.setStyle("-fx-background-color: OLIVEDRAB; -fx-background-radius: 115; -fx-Border-color: White;"
								+ "-fx-Border-radius: 112;-fx-font-size:20;-fx-Border-width:4;-fx-font-weight:bold; -fx-text-fill: white");
					}
				});
				bhad_1a.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						bhad_1a.setEffect(null);
						bhad_1a.setStyle("-fx-background-color: White; -fx-background-radius: 115; -fx-Border-color: OLIVEDRAB;"
								+ "-fx-Border-radius: 112;-fx-font-size:20;-fx-Border-width:5;-fx-font-weight:bold; -fx-text-fill: LIMEGREEN");
					}
				});
				
				bhad_1a.setOnAction(es->{
					GridPane gpp1=new GridPane();
					gpp1.setStyle("-fx-border-color:FORESTGREEN; -fx-background-color:LIMEGREEN;-fx-Border-width:2;");
					Scene scenenp1=new Scene(gpp1,850,540);
					gpp1.setHgap(30);
					gpp1.setVgap(8);
					
	  			    Text lins=new Text("Print Abstract Data Operation");
					lins.setStyle("-fx-font-size:25;-fx-font-weight:bold;");
					gpp1.add(lins,2,4);
						
						
					Text pins=new Text(" 1st AVL(level-traversal):");
					pins.setStyle("-fx-font-size:16;-fx-font-weight:bold;");
					gpp1.add(pins,2,11);
					
					
					TextArea ta1=new TextArea();
					ta1.setText(t.printSeatnum_Avltrav());
					//t.printSeatnum_Avltrav();
					ta1.setPrefSize(570, 320);
					ta1.setStyle("-fx-border-color:FORESTGREEN;");
					ta1.setWrapText(true);
					ta1.setEditable(false);////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					
					gpp1.add(ta1, 2, 12);
					
					Button b_back=new Button("<-- Back");
					b_back.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
					b_back.setPrefSize(70, 25);
					b_back.setTextFill(Color.BLACK);
			        
					b_back.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent e) {
							b_back.setEffect(shadow);
							b_back.setStyle("-fx-border-width: 2;-fx-background-color: Gold;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
							b_back.setTextFill(Color.WHITE);
						}
					});
					b_back.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent e) {
							b_back.setEffect(null);
							b_back.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
							b_back.setTextFill(Color.BLACK);
						}
					});
					gpp1.add(b_back, 6, 13);
					//gpp1.setHalignment(b_back, HPos.LEFT);
					
					b_back.setOnAction(searchbacccc->{
					s.setScene(scenead);
					});
					
					s.setScene(scenenp1);
				});
				
				
				Button bhad_2a=new Button("       2st AVL"+"\n"
						+ "(level-traversal)");
				bhad_2a.setPrefSize(220, 220);
				bhad_2a.setStyle("-fx-background-color: White; -fx-background-radius: 115; -fx-Border-color: OLIVEDRAB;"
						+ "-fx-Border-radius: 112;-fx-font-size:20;-fx-Border-width:5;-fx-font-weight:bold; -fx-text-fill: LIMEGREEN");
		
				bhad_2a.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						bhad_2a.setEffect(shadow);
						bhad_2a.setStyle("-fx-background-color: OLIVEDRAB; -fx-background-radius: 115; -fx-Border-color: White;"
								+ "-fx-Border-radius: 112;-fx-font-size:20;-fx-Border-width:4;-fx-font-weight:bold; -fx-text-fill: white");
					}
				});
				bhad_2a.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						bhad_2a.setEffect(null);
						bhad_2a.setStyle("-fx-background-color: White; -fx-background-radius: 115; -fx-Border-color: OLIVEDRAB;"
								+ "-fx-Border-radius: 112;-fx-font-size:20;-fx-Border-width:5;-fx-font-weight:bold; -fx-text-fill: LIMEGREEN");
					}
				});
				
				bhad_2a.setOnAction(sf->{
					GridPane gpp1=new GridPane();
					gpp1.setStyle("-fx-border-color:FORESTGREEN; -fx-background-color:LIMEGREEN;-fx-Border-width:2;");
					Scene scenenp1=new Scene(gpp1,850,540);
					gpp1.setHgap(30);
					gpp1.setVgap(8);
					
	  			    Text lins=new Text("Print Abstract Data Operation");
					lins.setStyle("-fx-font-size:25;-fx-font-weight:bold;");
					gpp1.add(lins,2,4);
						
						
					Text pins=new Text(" 2st AVL(level-traversal):");
					pins.setStyle("-fx-font-size:16;-fx-font-weight:bold;");
					gpp1.add(pins,2,11);
					
					
					TextArea ta1=new TextArea();
					ta1.setText(t.printAVG_Avltrav());
					
					ta1.setPrefSize(570, 320);
					ta1.setStyle("-fx-border-color:FORESTGREEN;");
					ta1.setWrapText(true);
					ta1.setEditable(false);////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					
					gpp1.add(ta1, 2, 12);
					
					Button b_back=new Button("<-- Back");
					b_back.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
					b_back.setPrefSize(70, 25);
					b_back.setTextFill(Color.BLACK);
			        
					b_back.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent e) {
							b_back.setEffect(shadow);
							b_back.setStyle("-fx-border-width: 2;-fx-background-color: Gold;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
							b_back.setTextFill(Color.WHITE);
						}
					});
					b_back.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent e) {
							b_back.setEffect(null);
							b_back.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
							b_back.setTextFill(Color.BLACK);
						}
					});
					gpp1.add(b_back, 6, 13);
					//gpp1.setHalignment(b_back, HPos.LEFT);
					
					b_back.setOnAction(searchbacccc->{
					s.setScene(scenead);
					});
					
					s.setScene(scenenp1);
				});
				
				had.getChildren().addAll(bhad_Dll,bhad_1a,bhad_2a);
				
				
					Button b_back=new Button("<-- Back");
	  			    b_back.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
					b_back.setPrefSize(70, 25);
					b_back.setTextFill(Color.BLACK);
			        
					b_back.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent e) {
							b_back.setEffect(shadow);
							b_back.setStyle("-fx-border-width: 2;-fx-background-color: Gold;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
							b_back.setTextFill(Color.WHITE);
						}
					});
					b_back.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent e) {
							b_back.setEffect(null);
							b_back.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
							b_back.setTextFill(Color.BLACK);
						}
					});
					hback.getChildren().add(b_back);
					b_back.setOnAction(klg->{
	  				s.setScene(scene1);
	  			});
  				
  			});
  			
  			
  			
  			
  			
  			
  			
  			
  			
  			
  			// print avl height
  			bhavl.setOnAction(eaq->{
  				GridPane gpp1=new GridPane();
				gpp1.setStyle("-fx-border-color:FORESTGREEN; -fx-background-color:LIMEGREEN;-fx-Border-width:2;");
				Scene scenenp2=new Scene(gpp1,850,540);
				gpp1.setHgap(30);
				gpp1.setVgap(8);
				
  			    Text lins=new Text("Print AVL Height Operation");
				lins.setStyle("-fx-font-size:25;-fx-font-weight:bold;");
				gpp1.add(lins,2,4);
					
				Text m=new Text("The Height of Two AVL:");
				m.setStyle("-fx-font-size:18;-fx-font-weight:bold;");
				gpp1.add(m,2,15);
				
				Text pins1=new Text(" 1st AVL:"+t.printSeatnum_Avlheight());
				pins1.setStyle("-fx-font-size:16;-fx-font-weight:bold;");
				gpp1.add(pins1,2,16);
				
				
				Text pins2=new Text(" 2st AVL:"+t.printAVG_Avlheight());
				pins2.setStyle("-fx-font-size:16;-fx-font-weight:bold;");
				gpp1.add(pins2,2,18);
				
				
				
				
				Button b_back=new Button("<-- Back");
				b_back.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
				b_back.setPrefSize(70, 25);
				b_back.setTextFill(Color.BLACK);
		        
				b_back.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						b_back.setEffect(shadow);
						b_back.setStyle("-fx-border-width: 2;-fx-background-color: Gold;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
						b_back.setTextFill(Color.WHITE);
					}
				});
				b_back.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						b_back.setEffect(null);
						b_back.setStyle("-fx-border-width: 2;-fx-background-color: GOLD;-fx-Border-color: White;-fx-font-size:12;-fx-font-weight:bold;");
						b_back.setTextFill(Color.BLACK);
					}
				});
				gpp1.add(b_back, 14, 45);
				//gpp1.setHalignment(b_back, HPos.LEFT);
				
				b_back.setOnAction(searchbacccc->{
				s.setScene(scene1);
				});
				
				s.setScene(scenenp2);
			});
  			
  			
  			
  			///////////////////////////////////////////////////////////////////////////////////
          
          
          
        }   
	});
        gp02.add(t03, 1, 6);
        gp02.add(r0_31, 1, 8);
        gp02.add(r0_32, 1, 9);
        gp02.add(next03, 2, 11);
		bp.setStyle("-fx-background-color: LIMEGREEN;-fx-Border-color: FORESTGREEN;-fx-Border-width:4;");
		
		
		bp.setTop(vb01);
		bp.setCenter(gp02);
		
        
        
        
        s.setTitle("Tawjihi Record");
        s.setScene(scene0);
        s.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

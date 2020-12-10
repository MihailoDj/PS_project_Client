/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller;

import com.github.lgooddatepicker.tableeditors.DateTableEditor;
import controller.Controller;
import domain.Director;
import domain.Movie;
import domain.Review;
import domain.User;
import domain.UserMovieCollection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import view.constant.Constants;
import view.coordinator.MainCoordinator;
import view.form.FrmMovieCollection;
import view.form.component.table.MovieTableModel;

/**
 *
 * @author Mihailo
 */
public class MovieCollectionController {
    private final FrmMovieCollection frmMovieCollection;
    
    public MovieCollectionController (FrmMovieCollection frmMovieCollection) {
        this.frmMovieCollection = frmMovieCollection;
        addActionListeners();
        addListSelectionListeners();
        addKeyListeners();
    }
    
    private void addActionListeners() {
        frmMovieCollection.addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                fillTblCollection();
            }
        });
        frmMovieCollection.btnDetailsActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = frmMovieCollection.getTblCollection().getSelectedRow();
                
                if (row != -1) {
                    Movie movie = ((MovieTableModel) frmMovieCollection.getTblCollection().getModel()).getMovieAt(row);
                    MainCoordinator.getInstance().addParam(Constants.PARAM_MOVIE, movie);
                    MainCoordinator.getInstance().openMovieDetailsForm();
                } else {
                    JOptionPane.showMessageDialog(frmMovieCollection, "You must select a movie", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        frmMovieCollection.btnReviewActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = frmMovieCollection.getTblCollection().getSelectedRow();
                Movie movie = ((MovieTableModel)frmMovieCollection.getTblCollection().getModel()).getMovieAt(selectedRow);
                User user = (User)MainCoordinator.getInstance().getParam(Constants.CURRENT_USER);
                Review review = new Review(){
                    {
                        setMovie(movie);
                        setUser(user);
                    }  
                };
                MainCoordinator.getInstance().addParam(Constants.PARAM_MOVIE, movie);
                MainCoordinator.getInstance().addParam(Constants.PARAM_REVIEW, review);
                MainCoordinator.getInstance().openReviewForm();
            }
        });
        frmMovieCollection.btnRemoveActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = frmMovieCollection.getTblCollection().getSelectedRow();
                User user = ((User)MainCoordinator.getInstance().getParam(Constants.CURRENT_USER));
                

                if (row != -1) {
                    try {
                        int check = JOptionPane.showConfirmDialog(frmMovieCollection, "Are you sure?",
                                "Remove movie", JOptionPane.YES_NO_OPTION);

                        if (check == JOptionPane.YES_OPTION) {
                            Movie movie = ((MovieTableModel) frmMovieCollection.getTblCollection().getModel()).getMovieAt(row);
{
                            UserMovieCollection umc = new UserMovieCollection() {
                                {
                                    setMovie(movie);
                                    setUser(user);
                                }
                            };
                            Controller.getInstance().deleteCollection(umc);
                        }

                            JOptionPane.showMessageDialog(frmMovieCollection, "Movie successfully removed",
                                    "Success", JOptionPane.INFORMATION_MESSAGE);
                        }

                    } catch (Exception ex) {
                        Logger.getLogger(MovieCollectionController.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(frmMovieCollection, "Unable to remove movie", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(frmMovieCollection, "You must select a movie", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    
    private void addListSelectionListeners() {
        frmMovieCollection.tblCollectionListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (frmMovieCollection.getTblCollection().getSelectedRow() != -1)
                    enableButtons();
                else
                    disableButtons();
            }
        });
    }
    
    private void addKeyListeners() {
        frmMovieCollection.filterKeyPressed(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                String filter = frmMovieCollection.getTxtFilter().getText().trim();
                filter(filter);
            }
        });
    }
    
    public void openForm() {
        prepareView();
        frmMovieCollection.setLocationRelativeTo(MainCoordinator.getInstance().getUserMainController().getFrmUserMain());
        frmMovieCollection.setTitle("My movies");
        frmMovieCollection.setVisible(true);
    }
    
    private void filter(String filter) {
        TableRowSorter<MovieTableModel> trs = new TableRowSorter<>((MovieTableModel) frmMovieCollection.getTblCollection().getModel());
        frmMovieCollection.getTblCollection().setRowSorter(trs);

        trs.setRowFilter(RowFilter.regexFilter("(?i)" + filter));
    }
    
    private void enableButtons() {
        frmMovieCollection.getBtnReview().setEnabled(true);
        frmMovieCollection.getBtnRemove().setEnabled(true);
        frmMovieCollection.getBtnDetails().setEnabled(true);
    }
    
    private void disableButtons() {
        frmMovieCollection.getBtnReview().setEnabled(false);
        frmMovieCollection.getBtnRemove().setEnabled(false);
        frmMovieCollection.getBtnDetails().setEnabled(false);
    }

    private void prepareView() {
        
    }
    
    private void fillTblCollection () {
        try {
            List<Movie> movies = new ArrayList<>();
            
            for (UserMovieCollection umc : Controller.getInstance().selectAllCollections()) {
                movies.add(umc.getMovie());
            }
            
            MovieTableModel mtm = new MovieTableModel(movies);
            frmMovieCollection.getTblCollection().setModel(mtm);
            setUpTableColumns();
        } catch (Exception ex) {
            Logger.getLogger(MovieCollectionController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(frmMovieCollection, "Error loading collection", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setUpTableColumns() throws Exception {
        List<Director> directors = Controller.getInstance().selectAllDirectors();
        JComboBox cbDirector = new JComboBox(directors.toArray());

        TableColumnModel tcm = frmMovieCollection.getTblCollection().getColumnModel();
        TableColumn tcDirector = tcm.getColumn(5);
        tcDirector.setCellEditor(new DefaultCellEditor(cbDirector));

        TableColumn tcReleaseDate = tcm.getColumn(2);
        tcReleaseDate.setCellEditor(new DateTableEditor());
        tcReleaseDate.setCellRenderer(new DateTableEditor());

        frmMovieCollection.getTblCollection().setAutoCreateRowSorter(true);
        frmMovieCollection.getTblCollection().getTableHeader().setResizingAllowed(false);

        frmMovieCollection.getTblCollection().setRowHeight(30);
        tcm.getColumn(0).setPreferredWidth(15);
        tcm.getColumn(1).setPreferredWidth(100);
        tcm.getColumn(2).setPreferredWidth(100);
        tcm.getColumn(3).setPreferredWidth(75);
        tcm.getColumn(4).setPreferredWidth(15);
        tcm.getColumn(5).setPreferredWidth(100);
    }
}

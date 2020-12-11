/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller;

import com.github.lgooddatepicker.tableeditors.DateTableEditor;
import communication.Communication;
import domain.Director;
import domain.Movie;
import domain.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.time.LocalDate;
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
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import view.constant.Constants;
import view.coordinator.MainCoordinator;
import view.form.FrmViewMovies;
import view.form.component.table.MovieTableModel;

/**
 *
 * @author Mihailo
 */
public class ViewAllMoviesController {

    private final FrmViewMovies frmViewMovies;

    public ViewAllMoviesController(FrmViewMovies frmViewMovies) {
        this.frmViewMovies = frmViewMovies;
        fillTblMovies();
        addActionListener();
        addListSelectionListener();
        addKeyListener();
        //addTableModelListener();
    }

    /*
    private void addTableModelListener() {
        
        frmViewMovies.getTableViewMoviesAddTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    int selRow = frmViewMovies.getTblMovies().getSelectedRow();
                
                    Movie movie = new Movie() {
                        {
                            setMovieID((int) frmViewMovies.getTblMovies().getModel().getValueAt(selRow, 0));
                            setName((String) frmViewMovies.getTblMovies().getModel().getValueAt(selRow, 1));
                            setReleaseDate((LocalDate) frmViewMovies.getTblMovies().getModel().getValueAt(selRow, 2));
                            setDescription((String) frmViewMovies.getTblMovies().getModel().getValueAt(selRow, 3));
                            setScore((double) frmViewMovies.getTblMovies().getModel().getValueAt(selRow, 4));
                            setDirector((Director) frmViewMovies.getTblMovies().getModel().getValueAt(selRow, 5));
                        }  
                    };

                    try {
                        Controller.getInstance().updateMovie(movie);
                        JOptionPane.showMessageDialog(frmViewMovies, "Movie updated successfully!", 
                                "Update movie", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception ex) {
                        Logger.getLogger(ViewAllMoviesController.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(frmViewMovies, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(frmViewMovies, e.getType(), "error", JOptionPane.INFORMATION_MESSAGE);
                }
                
            }
        });
    }
     */
    private void addKeyListener() {
        frmViewMovies.filterKeyPressed(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String filter = frmViewMovies.getTxtSearch().getText().trim();
                filter(filter);
            }
        });
    }

    private void addListSelectionListener() {
        frmViewMovies.getTableViewMoviesAddListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (frmViewMovies.getTblMovies().getSelectedRow() != -1) {
                    enableButtons();
                } else {
                    disableButtons();
                }
            }
        });
    }

    private void addActionListener() {
        frmViewMovies.addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                fillTblMovies();
            }
        });
        frmViewMovies.getBtnDetailsAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = frmViewMovies.getTblMovies().getSelectedRow();

                if (row != -1) {
                    Movie movie = ((MovieTableModel) frmViewMovies.getTblMovies().getModel()).getMovieAt(row);
                    MainCoordinator.getInstance().addParam(Constants.PARAM_MOVIE, movie);
                    MainCoordinator.getInstance().openMovieDetailsForm();
                } else {
                    JOptionPane.showMessageDialog(frmViewMovies, "You must select a movie", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frmViewMovies.getBtnAddMovieAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainCoordinator.getInstance().openMovieForm();
            }
        });

        frmViewMovies.getBtnDeleteAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = ((User)MainCoordinator.getInstance().getParam(Constants.CURRENT_USER));
                int row = frmViewMovies.getTblMovies().getSelectedRow();

                if (row != -1) {
                    try {
                        int check = JOptionPane.showConfirmDialog(frmViewMovies, "Are you sure?",
                                "Delete movie", JOptionPane.YES_NO_OPTION);

                        if (check == JOptionPane.YES_OPTION) {
                            Movie movie = ((MovieTableModel) frmViewMovies.getTblMovies().getModel()).getMovieAt(row);

                            MainCoordinator.getInstance().addParam(Constants.PARAM_MOVIE, null);
                            Communication.getInstance().deleteMovie(movie);
                            
                            JOptionPane.showMessageDialog(frmViewMovies, "Movie successfully deleted",
                                    "Success", JOptionPane.INFORMATION_MESSAGE);
                        }

                    } catch (Exception ex) {
                        Logger.getLogger(ViewAllMoviesController.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(frmViewMovies, "Unable to delete movie", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(frmViewMovies, "You must select a movie", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public void openForm() {
        prepareView();
        frmViewMovies.setLocationRelativeTo(MainCoordinator.getInstance().getMainContoller().getFrmMain());
        frmViewMovies.setVisible(true);
    }

    private void prepareView() {
        frmViewMovies.setTitle("View movies");
    }

    private void fillTblMovies() {
        List<Movie> movies = new ArrayList<>();

        try {
            movies = Communication.getInstance().selectAllMovies();
            MovieTableModel mtm = new MovieTableModel(movies);
            frmViewMovies.getTblMovies().setModel(mtm);

            setUpTableColumns();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frmViewMovies, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(ViewAllMoviesController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void setUpTableColumns() throws Exception {
        List<Director> directors = Communication.getInstance().selectAllDirectors();
        JComboBox cbDirector = new JComboBox(directors.toArray());

        TableColumnModel tcm = frmViewMovies.getTblMovies().getColumnModel();
        TableColumn tcDirector = tcm.getColumn(5);
        tcDirector.setCellEditor(new DefaultCellEditor(cbDirector));

        TableColumn tcReleaseDate = tcm.getColumn(2);
        tcReleaseDate.setCellEditor(new DateTableEditor());
        tcReleaseDate.setCellRenderer(new DateTableEditor());

        frmViewMovies.getTblMovies().setAutoCreateRowSorter(true);
        frmViewMovies.getTblMovies().getTableHeader().setResizingAllowed(false);

        frmViewMovies.getTblMovies().setRowHeight(30);
        tcm.getColumn(0).setPreferredWidth(15);
        tcm.getColumn(1).setPreferredWidth(100);
        tcm.getColumn(2).setPreferredWidth(100);
        tcm.getColumn(3).setPreferredWidth(75);
        tcm.getColumn(4).setPreferredWidth(15);
        tcm.getColumn(5).setPreferredWidth(100);
    }

    public void enableButtons() {
        frmViewMovies.getBtnDeleteMovie().setEnabled(true);
        frmViewMovies.getBtnDetails().setEnabled(true);
    }

    public void disableButtons() {
        frmViewMovies.getBtnDeleteMovie().setEnabled(false);
        frmViewMovies.getBtnDetails().setEnabled(false);
    }

    private void filter(String filter) {
        TableRowSorter<MovieTableModel> trs = new TableRowSorter<>((MovieTableModel) frmViewMovies.getTblMovies().getModel());
        frmViewMovies.getTblMovies().setRowSorter(trs);

        trs.setRowFilter(RowFilter.regexFilter("(?i)" + filter));
    }
}

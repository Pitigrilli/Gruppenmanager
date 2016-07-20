/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppeneinteilung.gui;

import gruppeneinteilung.model.Student;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 *
 * @author claus
 */
public class TransferableStudent implements Transferable {
    /*objecto to transfer with dnd*/

    Student student;

    DataFlavor studentFlavor = new DataFlavor(Student.class, Student.class.getSimpleName());
    
    TransferableStudent(Student student) {
        this.student = student;
        
    }

    Student getStudent() {
        return student;
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
       return new DataFlavor[]{studentFlavor};
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {

        return flavor.equals(studentFlavor);
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        
        if (flavor.equals(studentFlavor)) {
            return student;
        } else {
            throw new UnsupportedFlavorException(flavor);
        }
    }
}

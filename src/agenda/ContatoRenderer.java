package agenda;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.border.EmptyBorder;

public class ContatoRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        if (value instanceof Contato) {
            Contato c = (Contato) value;
            String icone = (c instanceof ContatoPessoal) ? "🏠" : "🏢";
            // HTML para deixar bonito
            String texto = String.format("<html><span style='font-size:12px'>%s <b>%s</b></span><br/><span style='color:gray;font-size:10px'>%s</span></html>", icone, c.getNome(), c.getTelefone());
            label.setText(texto);
        }
        label.setBorder(new EmptyBorder(5, 5, 5, 5));
        return label;
    }
}

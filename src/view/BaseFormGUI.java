package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

/**
 * Shared base class for form + table style panels
 * (AppointmentGUI, VeterinariansGUI, MedicalRecordsGUI, PetsGUI, OwnerGUI, ...).
 *
 * Provides a consistent, styled layout:
 *  - pastel form card (NORTH)
 *  - styled Add/Update/Delete/Clear buttons
 *  - clean white table with light header (CENTER)
 *
 * Subclasses only need to build their own fields and columns.
 */
public abstract class BaseFormGUI extends JPanel {
	private static final long serialVersionUID = 1L;

	protected JButton btnAdd;
	protected JButton btnUpdate;
	protected JButton btnDelete;
	protected JButton btnClear;

	protected JTable table;
	protected DefaultTableModel tableModel;

	private final String pageTitle;
	private final String pageSubtitle;

	/**
	 * @param pageTitle     large heading shown above the form (e.g. "Appointment details")
	 * @param pageSubtitle  one-line description under the heading
	 * @param columns       column headers for the table
	 */
	public BaseFormGUI(String pageTitle, String pageSubtitle, String[] columns) {
		this.pageTitle = pageTitle;
		this.pageSubtitle = pageSubtitle;

		setLayout(new BorderLayout(0, 14));
		setBackground(UITheme.PAGE_BG);
		setBorder(new EmptyBorder(20, 20, 20, 20));

		JPanel north = new JPanel(new BorderLayout(0, 14));
		north.setOpaque(false);
		north.add(buildHeader(), BorderLayout.NORTH);
		north.add(buildFormCard(), BorderLayout.CENTER);

		add(north, BorderLayout.NORTH);
		add(buildTableCard(columns), BorderLayout.CENTER);
	}

	private JPanel buildHeader() {
		JPanel header = new JPanel();
		header.setOpaque(false);
		header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));

		JLabel title = new JLabel(pageTitle);
		title.setFont(UITheme.FONT_TITLE);
		title.setForeground(UITheme.TEXT_PRIMARY);
		title.setAlignmentX(Component.LEFT_ALIGNMENT);

		JLabel subtitle = new JLabel(pageSubtitle);
		subtitle.setFont(UITheme.FONT_SUBTLE);
		subtitle.setForeground(UITheme.TEXT_SECONDARY);
		subtitle.setAlignmentX(Component.LEFT_ALIGNMENT);

		header.add(title);
		header.add(Box.createVerticalStrut(2));
		header.add(subtitle);
		return header;
	}

	/**
	 * Fresh GridBagConstraints per component (x, y position, column span,
	 * whether the component should stretch horizontally).
	 */
	protected GridBagConstraints gbc(int x, int y, int width, boolean fillHorizontal) {
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = x;
		c.gridy = y;
		c.gridwidth = width;
		c.insets = new Insets(6, 8, 6, 8);
		c.anchor = GridBagConstraints.WEST;
		if (fillHorizontal) {
			c.fill = GridBagConstraints.HORIZONTAL;
		}
		return c;
	}

	private JPanel buildFormCard() {
		JPanel card = new JPanel(new BorderLayout(0, 12));
		card.setBackground(UITheme.FORM_BG);
		card.setBorder(new EmptyBorder(16, 16, 16, 16));

		JPanel formPanel = new JPanel(new GridBagLayout());
		formPanel.setOpaque(false);

		int nextRow = addFields(formPanel);

		card.add(formPanel, BorderLayout.NORTH);
		card.add(buildButtonRow(), BorderLayout.SOUTH);
		return card;
	}

	private JPanel buildButtonRow() {
		JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
		row.setOpaque(false);

		btnAdd = styledButton("Add", UITheme.BTN_PRIMARY_BG, UITheme.BTN_PRIMARY_TXT);
		btnUpdate = styledButton("Update", UITheme.BTN_NEUTRAL_BG, UITheme.BTN_NEUTRAL_TXT);
		btnDelete = styledButton("Delete", UITheme.BTN_DANGER_BG, UITheme.BTN_DANGER_TXT);
		btnClear = styledButton("Clear", UITheme.BTN_NEUTRAL_BG, UITheme.BTN_NEUTRAL_TXT);

		row.add(btnAdd);
		row.add(btnUpdate);
		row.add(btnDelete);
		row.add(btnClear);
		return row;
	}

	private JButton styledButton(String text, Color bg, Color fg) {
		JButton btn = new JButton(text);
		btn.setFont(UITheme.FONT_BUTTON);
		btn.setBackground(bg);
		btn.setForeground(fg);
		btn.setFocusPainted(false);
		btn.setBorder(new EmptyBorder(8, 18, 8, 18));
		btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		return btn;
	}

	/**
	 * Subclasses build their own labels/fields onto formPanel here,
	 * using the inherited gbc() helper, and return the next free
	 * row index (unused now that buttons live in their own row, but
	 * kept for layout consistency with subclasses).
	 */
	protected abstract int addFields(JPanel formPanel);

	private JPanel buildTableCard(String[] columns) {
		JPanel card = new JPanel(new BorderLayout());
		card.setBackground(UITheme.CARD_BG);
		card.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(UITheme.BORDER, 1),
				new EmptyBorder(4, 4, 4, 4)));

		tableModel = new DefaultTableModel(columns, 0) {
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // table is read-only; edits happen via the form
			}
		};
		table = new JTable(tableModel);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowHeight(28);
		table.setFont(UITheme.FONT_TABLE_CELL);
		table.setForeground(UITheme.TEXT_PRIMARY);
		table.setGridColor(UITheme.BORDER);
		table.setShowVerticalLines(false);
		table.setSelectionBackground(UITheme.PASTEL_PURPLE_BG);
		table.setSelectionForeground(UITheme.TEXT_PRIMARY);

		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setFont(UITheme.FONT_TABLE_HEADER);
		tableHeader.setBackground(UITheme.PAGE_BG);
		tableHeader.setForeground(UITheme.TEXT_SECONDARY);
		tableHeader.setPreferredSize(new Dimension(0, 34));
		tableHeader.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, UITheme.BORDER));

		JScrollPane scroll = new JScrollPane(table);
		scroll.setBorder(BorderFactory.createEmptyBorder());
		card.add(scroll, BorderLayout.CENTER);
		return card;
	}

	// Shared getters available to every subclass/controller
	public JButton getBtnAdd() { return btnAdd; }
	public JButton getBtnUpdate() { return btnUpdate; }
	public JButton getBtnDelete() { return btnDelete; }
	public JButton getBtnClear() { return btnClear; }
	public JTable getTable() { return table; }
	public DefaultTableModel getTableModel() { return tableModel; }
}

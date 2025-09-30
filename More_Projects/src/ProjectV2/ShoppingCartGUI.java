package ProjectV2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class ShoppingCartGUI extends JFrame {

    private static final double PRICE_MULTIPLIER = 1.25; // increase all base prices by 25%

    private final String[] items = {
            "Apple", "Banana", "Orange", "Grapes", "Mango",
            "Pineapple", "Watermelon", "Strawberry", "Blueberry", "Cherry",
            "Papaya", "Pear", "Kiwi", "Peach", "Avocado"
    };
    private final double[] basePrices = {
    		 200, 100, 500, 400, 200,
             250, 150, 50, 70, 80,
             90, 78, 67,70, 80
    };

    private final NumberFormat currency = NumberFormat.getCurrencyInstance(new Locale("en", "PH"));
    private final DecimalFormat pct = new DecimalFormat("0.#%");

    private final DefaultTableModel catalogModel;
    private final DefaultTableModel cartModel;

    private double cartSubtotalAfterLineDiscounts = 0.0;
    private double totalLineSavings = 0.0;
    private double saleRate = 0.0;

    private final JLabel lblSubtotal = new JLabel("Subtotal (after qty discounts): ₱0.00");
    private final JLabel lblLineSavings = new JLabel("Savings from quantity discounts: -₱0.00");
    private final JLabel lblSale = new JLabel("Storewide sale: -₱0.00");
    private final JLabel lblGrand = new JLabel("Grand Total: ₱0.00");

    private final JTextField txtSalePercent = new JTextField("0", 5);

    public ShoppingCartGUI() {
        super("Shopping Cart (GUI)");

        // === Catalog Table ===
        catalogModel = new DefaultTableModel(new Object[]{"Code", "Item", "Price"}, 0) {
            @Override public boolean isCellEditable(int row, int column) { return false; }
        };
        for (int i = 0; i < items.length; i++) {
            double increased = basePrices[i] * PRICE_MULTIPLIER;
            catalogModel.addRow(new Object[]{i + 1, items[i], currency.format(increased)});
        }
        JTable tblCatalog = new JTable(catalogModel);
        tblCatalog.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane catalogScroll = new JScrollPane(tblCatalog);
        catalogScroll.setPreferredSize(new Dimension(420, 260));

        // === Cart Table ===
        cartModel = new DefaultTableModel(
                new Object[]{"Item", "Qty", "Unit Price", "Line Subtotal", "Qty Disc", "Line Total"}, 0) {
            @Override public boolean isCellEditable(int row, int column) { return false; }
        };
        JTable tblCart = new JTable(cartModel);
        JScrollPane cartScroll = new JScrollPane(tblCart);
        cartScroll.setPreferredSize(new Dimension(700, 260));

        // === Controls ===
        JSpinner spnQty = new JSpinner(new SpinnerNumberModel(1, 1, 999, 1));
        JButton btnAdd = new JButton("Add to Cart");
        JButton btnRemove = new JButton("Remove Selected");
        JButton btnClear = new JButton("Clear Cart");
        JButton btnApplySale = new JButton("Apply Sale %");
        JButton btnSaveReceipt = new JButton("Save Receipt"); // NEW

        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        controlPanel.add(new JLabel("Quantity:"));
        controlPanel.add(spnQty);
        controlPanel.add(btnAdd);
        controlPanel.add(btnRemove);
        controlPanel.add(btnClear);
        controlPanel.add(new JLabel("Sale %:"));
        controlPanel.add(txtSalePercent);
        controlPanel.add(btnApplySale);
        controlPanel.add(btnSaveReceipt); // add button to panel

        // === Totals Panel ===
        JPanel totalsPanel = new JPanel();
        totalsPanel.setLayout(new BoxLayout(totalsPanel, BoxLayout.Y_AXIS));
        lblSubtotal.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblLineSavings.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblSale.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblGrand.setAlignmentX(Component.LEFT_ALIGNMENT);
        totalsPanel.add(lblSubtotal);
        totalsPanel.add(lblLineSavings);
        totalsPanel.add(lblSale);
        totalsPanel.add(new JSeparator());
        totalsPanel.add(lblGrand);

        // === Layout ===
        JPanel left = new JPanel(new BorderLayout());
        left.add(new JLabel("Catalog"), BorderLayout.NORTH);
        left.add(catalogScroll, BorderLayout.CENTER);

        JPanel right = new JPanel(new BorderLayout());
        right.add(new JLabel("Cart"), BorderLayout.NORTH);
        right.add(cartScroll, BorderLayout.CENTER);

        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, left, right);
        split.setResizeWeight(0.45);

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.add(controlPanel, BorderLayout.NORTH);
        bottom.add(totalsPanel, BorderLayout.CENTER);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(split, BorderLayout.CENTER);
        getContentPane().add(bottom, BorderLayout.SOUTH);

        // === Actions ===
        btnAdd.addActionListener(e -> {
            int row = tblCatalog.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(this, "Please select an item from the catalog.", "No selection", JOptionPane.WARNING_MESSAGE);
                return;
            }
            int code = (int) catalogModel.getValueAt(row, 0);
            int qty = (int) spnQty.getValue();
            addItemToCart(code - 1, qty);
        });

        btnRemove.addActionListener(e -> {
            int row = tblCart.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(this, "Please select a row in the cart to remove.", "No selection", JOptionPane.WARNING_MESSAGE);
                return;
            }
            removeCartRow(row);
        });

        btnClear.addActionListener(e -> clearCart());
        btnApplySale.addActionListener(e -> { applySaleFromField(); refreshTotals(); });

        btnSaveReceipt.addActionListener(e -> saveReceiptToFile()); // NEW

        // Window settings
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1150, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    // === Business Logic ===
    private static double quantityDiscountRate(int qty) {
        if (qty >= 10) return 0.20;
        if (qty >= 5)  return 0.15;
        if (qty >= 3)  return 0.10;
        if (qty == 2)  return 0.05;
        return 0.0;
    }

    private void addItemToCart(int idx, int quantity) {
        if (idx < 0 || idx >= items.length || quantity <= 0) return;

        String itemName = items[idx];
        double unitPrice = basePrices[idx] * PRICE_MULTIPLIER;
        double lineSubtotal = unitPrice * quantity;
        double discRate = quantityDiscountRate(quantity);
        double lineDiscount = lineSubtotal * discRate;
        double lineTotal = lineSubtotal - lineDiscount;

        cartModel.addRow(new Object[]{
                itemName,
                quantity,
                currency.format(unitPrice),
                currency.format(lineSubtotal),
                discRate == 0.0 ? "-" : pct.format(discRate) + " (−" + currency.format(lineDiscount) + ")",
                currency.format(lineTotal)
        });

        recomputeTotals();
    }

    private void removeCartRow(int row) {
        cartModel.removeRow(row);
        recomputeTotals();
    }

    private void clearCart() {
        cartModel.setRowCount(0);
        saleRate = 0.0;
        txtSalePercent.setText("0");
        recomputeTotals();
    }

    private void applySaleFromField() {
        String s = txtSalePercent.getText().trim();
        double percent = 0.0;
        try { percent = Double.parseDouble(s); } catch (NumberFormatException ignored) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for sale percent.", "Invalid input", JOptionPane.ERROR_MESSAGE);
        }
        if (percent < 0) percent = 0;
        if (percent > 100) percent = 100;
        saleRate = percent / 100.0;
        txtSalePercent.setText(String.valueOf(percent));
    }

    private void recomputeTotals() {
        double subtotalAfterLineDiscounts = 0.0;
        double lineSavings = 0.0;

        for (int i = 0; i < cartModel.getRowCount(); i++) {
            String subStr  = (String) cartModel.getValueAt(i, 3);
            String discStr = (String) cartModel.getValueAt(i, 4);
            String totStr  = (String) cartModel.getValueAt(i, 5);

            double lineSubtotal = parseCurrency(subStr);
            double lineTotal    = parseCurrency(totStr);

            subtotalAfterLineDiscounts += lineTotal;
            double thisLineSavings = extractSavingsFromDiscColumn(discStr);
            lineSavings += thisLineSavings;
        }

        cartSubtotalAfterLineDiscounts = subtotalAfterLineDiscounts;
        totalLineSavings = lineSavings;

        refreshTotals();
    }

    private void refreshTotals() {
        double saleDiscount = cartSubtotalAfterLineDiscounts * saleRate;
        double grandTotal = cartSubtotalAfterLineDiscounts - saleDiscount;

        lblSubtotal.setText("Subtotal (after qty discounts): " + currency.format(cartSubtotalAfterLineDiscounts));
        lblLineSavings.setText("Savings from quantity discounts: -" + currency.format(totalLineSavings));
        lblSale.setText("Storewide sale " + (saleRate > 0 ? pct.format(saleRate) : "") + ": -" + currency.format(saleDiscount));
        lblGrand.setText("Grand Total: " + currency.format(grandTotal));
    }

    // === Receipt Save Feature ===
    private void saveReceiptToFile() {
        if (cartModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Cart is empty. Nothing to save.", "Empty Cart", JOptionPane.WARNING_MESSAGE);
            return;
        }

        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Save Receipt");
        chooser.setSelectedFile(new File("receipt.txt"));

        int result = chooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(buildReceiptString());
                JOptionPane.showMessageDialog(this, "Receipt saved to " + file.getAbsolutePath(), "Saved", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error saving file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private String buildReceiptString() {
        StringBuilder sb = new StringBuilder();
        sb.append("========== RECEIPT ==========\n");
        for (int i = 0; i < cartModel.getRowCount(); i++) {
            sb.append(cartModel.getValueAt(i, 1)) // qty
              .append(" x ")
              .append(cartModel.getValueAt(i, 0)) // item
              .append(" @ ").append(cartModel.getValueAt(i, 2)) // unit
              .append(" = ").append(cartModel.getValueAt(i, 5)) // line total
              .append("\n");
        }
        sb.append("-----------------------------\n");
        sb.append(lblSubtotal.getText()).append("\n");
        sb.append(lblLineSavings.getText()).append("\n");
        sb.append(lblSale.getText()).append("\n");
        sb.append(lblGrand.getText()).append("\n");
        sb.append("=============================\n");
        sb.append("Thank you for shopping!\n");
        return sb.toString();
    }

    // Helpers
    private double parseCurrency(String s) {
        String cleaned = s.replaceAll("[^0-9.\\-]", "");
        if (cleaned.isEmpty()) return 0.0;
        try { return Double.parseDouble(cleaned); } catch (NumberFormatException e) { return 0.0; }
    }

    private double extractSavingsFromDiscColumn(String discStr) {
        if (discStr == null || discStr.equals("-")) return 0.0;
        int open = discStr.indexOf("(−");
        int close = discStr.indexOf(')', open + 1);
        if (open >= 0 && close > open) {
            String money = discStr.substring(open + 2, close);
            return parseCurrency(money);
        }
        return 0.0;
    }

    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } catch (Exception ignored) {}
        SwingUtilities.invokeLater(ShoppingCartGUI::new);
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Task {
    String description;
    boolean isCompleted;

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    public void markAsCompleted() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        return description + "    -    " + (isCompleted ? "Completed" : "Pending");
    }
}

public class ToDoListAppGUI {
    private JFrame frame;
    private JTextField taskField;
    private DefaultListModel<Task> listModel;
    private JList<Task> taskList;

    public ToDoListAppGUI() {
        createGUI();
    }

    private void createGUI() {
        frame = new JFrame("To-Do List App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        taskField = new JTextField(25);
        JButton addButton = new JButton("Add Task");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });
        topPanel.add(taskField);
        topPanel.add(addButton);
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        JScrollPane listScrollPane = new JScrollPane(taskList);
        JPanel bottomPanel = new JPanel();
        JButton deleteButton = new JButton("Delete Task");
        deleteButton.setBackground(Color.RED);
        deleteButton.setForeground(Color.WHITE);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteTask();
            }
        });
        JButton markCompletedButton = new JButton("Mark as Completed");
        markCompletedButton.setBackground(Color.BLUE);
        markCompletedButton.setForeground(Color.WHITE);
        markCompletedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                markTaskAsCompleted();
            }
        });
        JLabel label = new JLabel("Select a task to delete or mark as completed.");
        label.setForeground(Color.GRAY);
        label.setFont(new Font("Arial", Font.ITALIC, 12));
        bottomPanel.add(label);
        bottomPanel.add(deleteButton);
        bottomPanel.add(markCompletedButton);
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(listScrollPane, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void addTask() {
        String task = taskField.getText();
        if (!task.isEmpty()) {
            listModel.addElement(new Task(task));
            taskField.setText("");
        }
    }

    private void deleteTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            listModel.remove(selectedIndex);
        }
    }

    private void markTaskAsCompleted() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            Task selectedTask = listModel.get(selectedIndex);
            selectedTask.markAsCompleted();
            listModel.set(selectedIndex, selectedTask);
            taskList.repaint();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ToDoListAppGUI();
            }
        });
    }
}

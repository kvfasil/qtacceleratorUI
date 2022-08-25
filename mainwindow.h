#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>

namespace Ui {
class MainWindow;
}

class MainWindow : public QMainWindow
{
    Q_OBJECT

public:
    explicit MainWindow(QWidget *parent = 0);
    ~MainWindow();

private slots:
    void on_home_Button_clicked();

    void on_epg_Button_clicked();

    void on_videos_Button_clicked();

    void on_apps_Button_clicked();

    void on_youtube_Button_clicked();

private:
    Ui::MainWindow *ui;
};

#endif // MAINWINDOW_H

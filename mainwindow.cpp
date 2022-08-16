#include "mainwindow.h"
#include "ui_mainwindow.h"

MainWindow::MainWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::MainWindow)
{
    ui->setupUi(this);
    ui->statusBar->setStyleSheet("background-color: #010101;color: #FFFFFF");
}

MainWindow::~MainWindow()
{
    delete ui;
}

void MainWindow::on_home_Button_clicked()
{
    ui->stackedWidget->setCurrentIndex(0);
}

void MainWindow::on_epg_Button_clicked()
{
    ui->stackedWidget->setCurrentIndex(1);
}

void MainWindow::on_videos_Button_clicked()
{
    ui->stackedWidget->setCurrentIndex(2);
}

void MainWindow::on_apps_Button_clicked()
{
    ui->stackedWidget->setCurrentIndex(3);
}

CREATE TABLE URL (
    url_id NUMBER PRIMARY KEY,
    url VARCHAR2(255) NOT NULL,
    total_views NUMBER DEFAULT 0,
    daily_views NUMBER DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE dailyView (
    log_id NUMBER PRIMARY KEY,
    url_id NUMBER,
    view_date DATE,
    views_count NUMBER DEFAULT 0,
    FOREIGN KEY (url_id) REFERENCES URL(url_id)
);

CREATE TABLE weeklyView (
    stat_id NUMBER PRIMARY KEY,
    url_id NUMBER,
    start_date DATE,
    end_date DATE,
    total_views NUMBER DEFAULT 0,
    average_daily_views NUMBER DEFAULT 0,
    FOREIGN KEY (url_id) REFERENCES URL(url_id)
);

CREATE TABLE dailyViewBackup (
    backup_id NUMBER PRIMARY KEY,
    url_id NUMBER,
    view_date DATE,
    views_count NUMBER DEFAULT 0,
    FOREIGN KEY (url_id) REFERENCES URL(url_id),
    FOREIGN KEY (backup_id) REFERENCES dailyView(log_id)
);

CREATE TABLE dailyToWeeklyMapping (
    daily_id NUMBER,
    weekly_id NUMBER,
    FOREIGN KEY (daily_id) REFERENCES DailyViewBackup(backup_id),
    FOREIGN KEY (weekly_id) REFERENCES WeeklyView(stat_id)
);
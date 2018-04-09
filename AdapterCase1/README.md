- cite http://www.runoob.com/design-pattern/adapter-pattern.html
![architecture](http://www.runoob.com/wp-content/uploads/2014/08/adapter_pattern_uml_diagram.jpg)

# structure 
- AdapterPatternDemo: process of implement 
    - <- AudioPlayer implement MediaPlayer: 分流, 根据不同的情况实现不同的操作
    - <- MediaAdapter implement MediaPlayer: 分流 根据情况生成不同对象
        - <- advancedMediaPlayer: 分流 操作 
            - <- mp4Player: 实现 mp4 操作 
            - <- vlcPlayer: 实现 vlc 操作 
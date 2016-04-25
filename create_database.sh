#!/bin/bash

mysql -uroot -e 'DROP DATABASE dilab_lib;’

mysql -uroot -e 'CREATE DATABASE dilab_lib;'

mysql -uroot -e 'SHOW DATABASES ; '
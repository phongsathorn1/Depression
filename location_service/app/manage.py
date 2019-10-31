#!/usr/bin/env python
"""Django's command-line utility for administrative tasks."""
import py_eureka_client.eureka_client as eureka_client
import os
import sys


def main():
    server_port = 8888
    eureka_client.init(eureka_server="localhost",
                   app_name="your_app_name",
                   instance_port=server_port)
    os.environ.setdefault('DJANGO_SETTINGS_MODULE', 'app.settings')
    try:
        from django.core.management import execute_from_command_line
    except ImportError as exc:
        raise ImportError(
            "Couldn't import Django. Are you sure it's installed and "
            "available on your PYTHONPATH environment variable? Did you "
            "forget to activate a virtual environment?"
        ) from exc
    execute_from_command_line(sys.argv)


if __name__ == '__main__':
    main()

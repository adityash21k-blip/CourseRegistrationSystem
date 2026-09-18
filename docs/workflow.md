# System Workflow

The following workflow describes how the user interacts with the Course Registration System.


                         START
                           |
                           v
                  +------------------+
                  |    Main Menu     |
                  +--------+---------+
                           |
             +-------------+-------------+
             |             |             |
             v             v             v
      Student Module  Course Module  Registration
             |             |             |
             v             v             v
        Perform       Perform       Perform
        Student       Course       Registration
        Operation     Operation      Operation
             |             |             |
             +-------------+-------------+
                           |
                           v
                  +------------------+
                  | Validate Input   |
                  +--------+---------+
                           |
                    Valid / Invalid
                           |
              +------------+------------+
              |                         |
            Valid                    Invalid
              |                         |
              v                         v
        Process Request          Display Error
              |                         |
              v                         |
        Save Data ----------------------+
              |
              v
       Display Result
              |
              v
          Main Menu
              |
              v
             EXIT